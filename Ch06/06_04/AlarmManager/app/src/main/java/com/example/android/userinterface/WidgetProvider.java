package com.example.android.userinterface;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.List;

// Have Widget class extend AppWidgetProvider
public class WidgetProvider extends AppWidgetProvider {

    // Create TAG for logging
    private static final String TAG = "WidgetProvider";

    // Create Preferences constants
    private static final String PREFERENCES_KEY = "prefs_key";
    private static final String ITEM_KEY = "item_key";

    // onUpdate() is called by the application framework whenever
    // the widget is updated
    @Override
    public void onUpdate(Context context,
                         AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        // Log information
        Log.i(TAG, "onUpdate: ");

        // Create a data set of specials
        List<Special> specials = new ArrayList<>();

        // Add 3 specials to loop through
        specials.add(new Special(R.string.pizza, R.drawable.pizza));
        specials.add(new Special(R.string.quinoa_salad, R.drawable.quinoa_salad));
        specials.add(new Special(R.string.mushrooms, R.drawable.stuffed_mushrooms));

        // Create an instance of the SharedPreference class, passing the prefs key,
        // and the mode (private)
        SharedPreferences preferences = context.getSharedPreferences(
                PREFERENCES_KEY, Context.MODE_PRIVATE);

        // Retrieve the current Special
        // The default value is 0 if none is already set,
        // so we will be looking at the first item
        int currentSpecial = preferences.getInt(ITEM_KEY, 0);

        // If it is the last special...
        if (currentSpecial == specials.size() - 1) {

            // Reset the current special to 0
            currentSpecial = 0;

            // If it is NOT the last special...
        } else {

            // Increment the current special
            currentSpecial++;
        }

        // Store the current special into the prefs
        preferences.edit()
                .putInt(ITEM_KEY, currentSpecial)
                .apply();

        // Get the current special from the list
        Special foodItem = specials.get(currentSpecial);

        // Get the imageId of the currentSpecial
        int imageId = foodItem.getImageId();

        // Get the foodName of the currentSpecial
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

        // Set up a PendingIntent that has instructions for what
        // happens when the user clicks the button on the widget
        Intent intent = new Intent(context, WidgetProvider.class);

        // Set an (UPDATE) action
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

        // Set an extra; the IDS of the app widget(s)
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

        // Take the Intent and wrap it inside of a PendingIntent
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
        );

        // Set number of seconds you want to wait until the next update
        int seconds = 3;

        // Create an instance of the AlarmManager class
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        // Issue a request to call the update again in 3 seconds by calling the setExact() method.
        // You pass the Alarm Type, the seconds in which to update, and the pending intent itself.
        // The AlarmManager manages the updates of the Widget, opposed to button clicks
        alarmManager.setExact(
                AlarmManager.RTC, // Alarm type, doesn't wake up the device while sleep
                System.currentTimeMillis() + (seconds * 1000), // The Time
                pendingIntent); // The Pending Intent
    }
}