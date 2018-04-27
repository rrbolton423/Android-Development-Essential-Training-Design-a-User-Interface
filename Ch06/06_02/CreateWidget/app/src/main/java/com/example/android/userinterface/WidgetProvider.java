package com.example.android.userinterface;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

// Have Widget class extend AppWidgetProvider
public class WidgetProvider extends AppWidgetProvider {

    // Create TAG for logging
    private static final String TAG = "WidgetProvider";

    // onUpdate() is called by the application framework whenever
    // the widget is updated
    @Override
    public void onUpdate(Context context,
                         AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        // When the method is called, I'm creating an instance of
        // my Special class, with the 2 integer values; one for a String
        // and another for a drawable.
        Special foodItem = new Special(R.string.pizza, R.drawable.pizza);

        // Get the image id as a int variable
        int imageId = foodItem.getImageId();

        // Get the food name as a String variable
        String foodName = context.getString(foodItem.getNameId());

        // This for loop is where you actually update the widget. The reason
        // for the loop is because you can have more than one instance of the
        // same widget.
        for (int widgetId : appWidgetIds) {

            // The RemoteViews object gives you access to the widget layout file,
            // and from there you can set text values and image resources.
            RemoteViews remoteViews = new RemoteViews(
                    context.getPackageName(), R.layout.widget_layout);

            // Set text values and image resources on the widget
            remoteViews.setTextViewText(R.id.food_name, foodName);
            remoteViews.setImageViewResource(R.id.food_image, imageId);

            // A call to updateAppWidget() is what the user sees.
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }
}
