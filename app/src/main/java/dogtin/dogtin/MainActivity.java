package dogtin.dogtin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());


        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        if(AccessToken.getCurrentAccessToken() != null){
                            Intent intent = new Intent(MainActivity.this, MatchActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(MainActivity.this, FaceFragment.class);
                            startActivity(intent);
                        }
                    }
                }
        ).executeAsync();

        Intent intent = new Intent(MainActivity.this, MatchActivity.class);
        startActivity(intent);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
