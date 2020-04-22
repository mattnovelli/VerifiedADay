package com.example.verified;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class MainActivity extends AppCompatActivity {
    private ConfigurationBuilder cb;
    private Twitter twitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("kz1TfvAMkW6nXoByfLlpzAcwE")
                .setOAuthConsumerSecret("ioGeVBDBLLLYhMVg1NJVPwRFzLc1kUTBxR6yW4GpmXguZChDUa")
                .setOAuthAccessToken("1252348218802921472-7tQhBxzAzAP3fFWIbwD6wnvqNZAoiJ")
                .setOAuthAccessTokenSecret("Uq1DsVGwVHFDDQd057uus7sK8kRoIG3UleNo1pPNQeLzo");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        try {
            twitter.updateStatus("Verifried is online!");
        } catch (Exception e) {
            System.out.println("oopsies");
        }
        Button tweetButton = (Button) findViewById(R.id.tweetButton);
    }

    public String tweetCreate() {
        final TextView tweet = (TextView) findViewById(R.id.customText);
        RequestQueue queue1 = Volley.newRequestQueue(this);
        //Get.friends/Ids sample string request experiment
        StringRequest getFriends = new StringRequest(Request.Method.GET, "https://api.twitter.com/1.1/friends/ids.json",
                new Response.Listener<String>() {
                    @SuppressLint("SetTextI18n")
                    public void onResponse(String response) {
                        // Do something with response
                        tweet.setText("verified");
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                // handle error
                tweet.setText("That didn't work!");
            }
        });
        queue1.add(getFriends);
        System.out.println(tweet.toString());
        return tweet.toString();
    }
}


    /*Button newPersonButton = (Button) findViewById(R.id.newPersonButton);

    //click new person button?
    public String clicked() {
        //clicks button
        newPersonButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        if (newPersonButton.isPressed()) {
            return "verified";
        }
        return "yesterdays user??";
    }
    //send tweet?
    public String tweet() {
        if (clicked().equals("verified")) {
            tweetButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                }
            });
            return "tweet";
        }
        return null;
    }*/

//}
