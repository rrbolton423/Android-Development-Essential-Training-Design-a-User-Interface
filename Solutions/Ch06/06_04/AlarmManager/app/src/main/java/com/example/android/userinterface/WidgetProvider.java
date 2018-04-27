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

public class WidgetProvider extends AppWidgetProvider {
    private static final String TAG = "WidgetProvider";

    private static final String PREFERENCES_KEY = "prefs_key";
    private static final String ITEM_KEY = "item_key";

    @Override
    public void onUpdate(Context context,
                         AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        Log.i(TAG, "onUpdate: ");

        List<Special> specials = new ArrayList<>();
        specials.add(new Special(R.string.pizza, R.drawable.pizza));
        specials.add(new Special(R.string.quinoa_salad, R.drawable.quinoa_salad));
        specials.add(new Special(R.string.mushrooms, R.drawable.stuffed_mushrooms));

        SharedPreferences preferences = context.getSharedPreferences(
                PREFERENCES_KEY, Context.MODE_PRIVATE);
        int currentSpecial = preferences.getInt(ITEM_KEY, 0);
        if (currentSpecial == specials.size() - 1) {
            currentSpecial = 0;
        } else {
            currentSpecial++;
        }
        preferences.edit()
                .putInt(ITEM_KEY, currentSpecial)
                .apply();

        Special foodItem = specials.get(currentSpecial);
        int imageId = foodItem.getImageId();
        String foodName = context.getString(foodItem.getNameId());

        for (int widgetId : appWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(
                    context.getPackageName(), R.layout.widget_layout);
            remoteViews.setTextViewText(R.id.food_name, foodName);
            remoteViews.setImageViewResource(R.id.food_image, imageId);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }

        Intent intent = new Intent(context, WidgetProvider.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
        );

        int seconds = 3;
        AlarmManager alarmManager = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);
        alarmManager.setExact(AlarmManager.RTC,
                System.currentTimeMillis() + (seconds *1000),
                pendingIntent);

    }
}
