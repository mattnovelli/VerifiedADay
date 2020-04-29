package com.example.verified;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import twitter4j.User;


public class MainActivity extends AppCompatActivity {
    private CustomTweet newTweet;
    private User targetUser;
    private String name;
    private String handle;
    int followers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            regenerateTarget();
        } catch (Exception e) {
            System.out.println("oopsies");
        }
        final Button newPersonButton = findViewById(R.id.newPersonButton);
        newPersonButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    public void run() {
                        try {
                            regenerateTarget();
                        } catch (Exception e) {
                            System.out.println("oopsies");
                        }
                    }
                }).start();
            }
        });

        final Button tweetButton = findViewById(R.id.tweetButton);
        tweetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        EditText text = (EditText)findViewById(R.id.customText);
                        String value = text.getText().toString();
                        newTweet.sendTweet("@" + handle + value);
                    }
                }).start();
            }
        });

    }
    public void regenerateTarget() {
        CustomTweet newTweet = new CustomTweet();
        User targetUser = newTweet.getRandomFriend();
        name = targetUser.getName();
        handle = targetUser.getScreenName();
        followers = targetUser.getFollowersCount();

        TextView userHandle = (TextView) findViewById(R.id.userHandle);
        userHandle.setText(handle);

        TextView realname = (TextView) findViewById(R.id.realName);
        realname.setText(name);

        TextView userFollowers = (TextView) findViewById(R.id.userFollowers);
        userFollowers.setText(followers + " followers");
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
