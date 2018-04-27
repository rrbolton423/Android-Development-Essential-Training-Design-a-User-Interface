package com.example.android.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the ViewGroup that's at the root of this layout
        ViewGroup container = (ViewGroup) findViewById(R.id.container);

        // Create an instance of MyTextView
        MyTextView tv = new MyTextView(this, "Purple", android.R.color.holo_purple);

        // Add the TextView to the container (LinearLayout)
        container.addView(tv);

        // Create an instance of MyTextView
        tv = new MyTextView(this, "Orange", android.R.color.holo_orange_light);

        // Add the TextView to the container (LinearLayout)
        container.addView(tv);
    }
}
