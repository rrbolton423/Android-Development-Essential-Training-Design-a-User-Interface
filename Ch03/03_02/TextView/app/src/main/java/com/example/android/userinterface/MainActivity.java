package com.example.android.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the TextView
        TextView tv = (TextView) findViewById(R.id.textView);

        // Set a scrolling movement method on the TextView
        tv.setMovementMethod(new ScrollingMovementMethod());
    }
}
