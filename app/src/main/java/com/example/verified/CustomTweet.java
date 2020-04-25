package com.example.verified;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class CustomTweet {
    private String customTweet;
    public void sendTweet() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("vS4OiZPnWYUadzkvVdjEXiVZt")
                .setOAuthConsumerSecret("C0ZazMsghJwfj19jNkyiauH8INBpAKDYdzhA1ieaUFDK4vXnnF")
                .setOAuthAccessToken("1252348218802921472-KbdNILC36MI8AQ9JnUfGBHQN1Rmx5f")
                .setOAuthAccessTokenSecret("mi5UFWog6LRTwMrFo5eCEQx18IHl1hpjJZUfN19MxLd36");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            twitter.updateStatus(customTweet);
        } catch (Exception e) {
            System.out.println("oopsies:" + e);
        }
    }
    CustomTweet(String tweet) {
        customTweet = tweet;
    }
}
