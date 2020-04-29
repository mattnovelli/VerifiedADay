package com.example.verified;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class CustomTweet {
//    private String customTweet;
    private Twitter twitter = ConfigurationFactory();
    public void sendTweet(String text) {
        try {
            twitter.updateStatus(text);
        } catch (Exception e) {
            System.out.println("oopsies:" + e);
        }
    }
    public User getRandomFriend() {
        List<User> users;
        try {
            long cursor = -1;
            users = twitter.getFriendsList("verified", cursor);
            Random random = new Random();
            return (users.get(random.nextInt(users.size())));
        } catch (Exception e) {
            System.out.println("oops");
        }
        return null;
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
