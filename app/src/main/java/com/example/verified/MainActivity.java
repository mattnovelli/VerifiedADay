package com.example.verified;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tweetButton = (Button) findViewById(R.id.tweetButton);
    }

    public String tweetCreate() {
        TextView tweet = (TextView) findViewById(R.id.customTweeteditText);
        RequestQueue queue1 = Volley.newRequestQueue(this);
        //Get.friends/Ids sample string request experiment
        StringRequest getFriends = new StringRequest(Request.Method.GET, "https://api.twitter.com/1.1/friends/ids.json",
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        tweet.setText("Response is: " + response.substring(0, 500));
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });
        queue1.add(getFriends);
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

}
