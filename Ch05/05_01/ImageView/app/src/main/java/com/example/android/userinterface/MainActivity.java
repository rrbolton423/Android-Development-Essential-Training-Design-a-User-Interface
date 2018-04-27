package com.example.android.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Declare ImageView component
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the ImageView
        imageView = (ImageView) findViewById(R.id.foodImage);
    }

    // This messages changes the food image
    public void clickHandler(View view) {

        // Set the image of the ImageView to artichokes
        imageView.setImageResource(R.drawable.artichokes);
    }
}
