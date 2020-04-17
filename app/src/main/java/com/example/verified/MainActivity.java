package com.example.verified;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Button tweetButton = (Button) findViewById(R.id.tweetButton);
    Button newPersonButton = (Button) findViewById(R.id.newPersonButton);

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
    }
    
}
