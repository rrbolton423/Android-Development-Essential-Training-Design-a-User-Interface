package com.example.android.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup container = (ViewGroup) findViewById(R.id.container);
        MyTextView tv = new MyTextView(this, "Purple", android.R.color.holo_purple);
        container.addView(tv);
        tv = new MyTextView(this, "Orange", android.R.color.holo_orange_light);
        container.addView(tv);

    }

}
