package com.example.verified;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.text.NumberFormat;
import java.util.List;
import java.util.Random;

import twitter4j.User;


public class MainActivity extends AppCompatActivity {
    private CustomTweet newTweet = new CustomTweet();
    private User targetUser;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            regenerateTarget();
        } catch (Exception e) {
            System.out.println("oopsies in onCreate: " + e);
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
                            System.out.println("oopsies in newPersonButton" + e);
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
                        EditText customText = (EditText) findViewById(R.id.customText);
                        System.out.println("current user is" + targetUser);
                        String tweet = "@" + targetUser.getScreenName() + " " + customText.getText().toString();
                        newTweet.sendTweet(tweet);
                        customText.getText().clear();
                    }
                }).start();
                Toast.makeText(MainActivity.this, "Tweet sent!",
                        Toast.LENGTH_SHORT).show();
                //regenerateTarget();
            }
        });

    }

    public void regenerateTarget() {
        //newTweet = new CustomTweet();
        NumberFormat customFormat = NumberFormat.getInstance();
        customFormat.setGroupingUsed(true);
        userList = newTweet.twitterAPIFriends();

        Random random = new Random();
        targetUser = userList.get(random.nextInt(userList.size()));

        ImageView profilePicture = (ImageView) findViewById(R.id.profilePicture);
        try {
            URL pic = new URL(targetUser.getBiggerProfileImageURLHttps());
            InputStream is = (InputStream) pic.getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            profilePicture.setImageDrawable(d);
        } catch (Exception e) {
            System.out.println("oopsies Could not fetch profile pic");
            e.printStackTrace();
        }

        TextView userHandle = (TextView) findViewById(R.id.userHandle);
        userHandle.setText("@" + targetUser.getScreenName());

        TextView realname = (TextView) findViewById(R.id.realName);
        realname.setText(targetUser.getName());

        TextView userFollowers = (TextView) findViewById(R.id.userFollowers);
        userFollowers.setText(customFormat.format(targetUser.getFollowersCount()) + " followers");
    }
}