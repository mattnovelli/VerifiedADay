package com.example.verified;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class CustomTweet {
    private Twitter twitter = ConfigurationFactory();
    private List<User> users = null;
    private final long VERIFIED_USER_ID = 63796828;
    public void sendTweet(String text) {
        try {
            twitter.updateStatus(text);
        } catch (Exception e) {
            System.out.println("oopsies:" + e);
        }
    }
    public List<User> twitterAPIFriends() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("making twitter API call!");
                    users = twitter.getFriendsList(VERIFIED_USER_ID, -1);
                    //System.out.println("users" + users);
                    //Thread.sleep(1000);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (TwitterException e) {
                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }).start();
        return users;
    }
    public User getRandomFriend() {
//        Random random = new Random();
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
