package com.example.verified;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class CustomTweet {
    private Twitter twitter = ConfigurationFactory();
    private PagableResponseList<User> users;
    private User sampleuser;
    public void sendTweet(String text) {
        try {
            twitter.updateStatus(text);
        } catch (Exception e) {
            System.out.println("oopsies:" + e);
        }
    }
    public User getRandomFriend() {
        new Thread(new Runnable() {
            public void run() {
                long cursor = 1;
                try {
                    users = twitter.getFriendsList("verified", cursor);
                    System.out.println("users list: " + users);
                } catch (TwitterException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Random random = new Random();
//        return users.get(random.nextInt(users.size()));
        return users.get(1);
    }


    public Twitter ConfigurationFactory() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("vS4OiZPnWYUadzkvVdjEXiVZt")
                .setOAuthConsumerSecret("C0ZazMsghJwfj19jNkyiauH8INBpAKDYdzhA1ieaUFDK4vXnnF")
                .setOAuthAccessToken("1252348218802921472-KbdNILC36MI8AQ9JnUfGBHQN1Rmx5f")
                .setOAuthAccessTokenSecret("mi5UFWog6LRTwMrFo5eCEQx18IHl1hpjJZUfN19MxLd36");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        return twitter;
    }
//    CustomTweet(String tweet) {
//        customTweet = tweet;
//    }
}
