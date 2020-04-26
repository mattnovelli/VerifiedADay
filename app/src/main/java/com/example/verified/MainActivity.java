package com.example.verified;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    String newVerified;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button newPersonButton = findViewById(R.id.newPersonButton);
        newPersonButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                         newVerified = "@ new person"; //randomized array of verifieds?
                    }
                }).start();
            }
        });

        final Button tweetButton = findViewById(R.id.tweetButton);
        tweetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        CustomTweet newTweet = new CustomTweet(newVerified + " " + "hello world");
                        newTweet.sendTweet();
                    }
                }).start();
            }
        });

    }

//    public String tweetCreate() {
//        final TextView tweet = (TextView) findViewById(R.id.customText);
//        RequestQueue queue1 = Volley.newRequestQueue(this);
//        //Get.friends/Ids sample string request experiment
//        StringRequest getFriends = new StringRequest(Request.Method.GET, "https://api.twitter.com/1.1/friends/ids.json",
//                new Response.Listener<String>() {
//                    @SuppressLint("SetTextI18n")
//                    public void onResponse(String response) {
//                        // Do something with response
//                        tweet.setText("verified");
//                    }
//                }, new Response.ErrorListener() {
//            public void onErrorResponse(VolleyError error) {
//                // handle error
//                tweet.setText("That didn't work!");
//            }
//        });
//        queue1.add(getFriends);
//        System.out.println(tweet.toString());
//        return tweet.toString();
//    }
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
