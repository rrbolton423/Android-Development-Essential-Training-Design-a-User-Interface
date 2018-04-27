package com.example.android.userinterface;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.foodImage);
    }

    public void clickHandler(View view) {
//        imageView.setImageResource(R.drawable.artichokes);

        // Create the name of the image in the form of a String
        String imageName = "artichokes.jpg";

        // Try to create an InputStream
        // The Stream is returned by opening the assets folder
        // and looking for a particular image
        try (InputStream stream = getAssets().open(imageName)) {

            // Get a reference to a drawable object
            // Create the drawable from the stream that was previously created
            Drawable d = Drawable.createFromStream(stream, null);

            // The the new drawable to the ImageView
            imageView.setImageDrawable(d);

            // IOException Handle
        } catch (IOException e) {

            // Print the stack trace
            e.printStackTrace();
        }
    }
}
