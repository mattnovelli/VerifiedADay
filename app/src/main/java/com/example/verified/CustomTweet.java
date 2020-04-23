package com.example.verified;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class CustomTweet {
    private String customTweet;
    public void sendTweet() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("kz1TfvAMkW6nXoByfLlpzAcwE")
                .setOAuthConsumerSecret("ioGeVBDBLLLYhMVg1NJVPwRFzLc1kUTBxR6yW4GpmXguZChDUa")
                .setOAuthAccessToken("1252348218802921472-7tQhBxzAzAP3fFWIbwD6wnvqNZAoiJ")
                .setOAuthAccessTokenSecret("Uq1DsVGwVHFDDQd057uus7sK8kRoIG3UleNo1pPNQeLzo");
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
