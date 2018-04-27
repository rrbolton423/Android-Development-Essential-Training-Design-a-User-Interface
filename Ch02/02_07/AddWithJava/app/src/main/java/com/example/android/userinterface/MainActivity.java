package com.example.android.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Declare fields
    ViewGroup buttonContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the ViewGroup
        buttonContainer = (ViewGroup) findViewById(R.id.buttonContainer);
    }

    // This method adds a new button to the linear layout (ViewGroup)
    public void clickHandler(View view) {

        // Create a Button
        Button button = new Button(this);

        // Set the text of the Button
        button.setText(R.string.click_me);

        // Add the Button to the container
        buttonContainer.addView(button);
    }
}
