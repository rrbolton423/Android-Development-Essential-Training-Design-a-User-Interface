package com.example.android.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.foodImage);

        // Load an Image resource using the Picasso library,
        // Get an instance of Picasso, then load a
        // specific Image resource into an ImageView container
        Picasso.get().load(R.drawable.apple_pie).into(imageView);
    }

    public void clickHandler(View view) {
//        imageView.setImageResource(R.drawable.artichokes);

        // Reference a Image file from the assets directory
        String imageName = "file:///android_asset/artichokes.jpg";

        // This version of the load() method looks for a String value;
        // the path of the file.
        // The fit() method can be called before the into() method to
        // have the image's size and aspect ratio changed / resized
        // on the fly to fit the current dimensions of the ImageView,
        // instead of the ImageView being changed to match the file
        Picasso.get().load(imageName).fit().into(imageView);

//        try (InputStream stream = getAssets().open(imageName)) {
//            Drawable d = Drawable.createFromStream(stream, null);
//            imageView.setImageDrawable(d);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
