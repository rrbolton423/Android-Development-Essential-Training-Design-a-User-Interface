package com.example.android.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the TextView
        TextView productText = (TextView) findViewById(R.id.productName);

        // Get the String value from the resources, and pass a placeholder for the String
        String productName = String.format(getString(R.string.delicious_pie), "Cherry");

        // Apply the String to the TextView
        productText.setText(productName);
    }
}
