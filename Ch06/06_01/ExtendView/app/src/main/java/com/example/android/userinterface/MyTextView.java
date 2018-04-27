package com.example.android.userinterface;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatTextView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

// Have TextView class extend AppCompatTextView for backward compatibility
public class MyTextView extends AppCompatTextView {

    // Have constructor accept a context, the color name, and the color id
    public MyTextView(Context context, final String coloName, int colorId) {
        super(context);

        // Create a padding size of 20
        int paddingSize = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 20,
                context.getResources().getDisplayMetrics()
        );

        // Create a Linear LayoutParams object to manipulate the layout parameters of the TextView.
        // Make the TextView width match parent, and the height wrap the content
        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

        // Set the basic measurements with the LayoutParams object,
        // specifically, the margins of the layout
        lp.setMargins(0, paddingSize, 0, 0);

        // Set the layout parameters of the TextView
        setLayoutParams(lp);

        // Set the padding of the TextView
        setPadding(0, paddingSize, 0, paddingSize);

        // Set the Background Color of the TextView
        if (Build.VERSION.SDK_INT >= 23) {
            setBackgroundColor(getResources().getColor(colorId, null));
        } else {
            setBackgroundColor(getResources().getColor(colorId));
        }

        // Display the Text that was passed in the TextView
        setText(coloName);

        // Set the TextSize of the TextView
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);

        // Set the Typeface of the TextView
        setTypeface(getTypeface(), Typeface.BOLD);

        // Align the Text in the TextView
        setTextAlignment(TEXT_ALIGNMENT_CENTER);

        // Handle a click event for the TextView
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display a Toast Message
                Toast.makeText(getContext(), String.format("This box is %s ", coloName), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
