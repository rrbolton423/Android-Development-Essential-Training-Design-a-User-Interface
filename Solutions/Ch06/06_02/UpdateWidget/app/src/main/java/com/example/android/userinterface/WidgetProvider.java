package com.example.android.userinterface;

import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {
    private static final String TAG = "WidgetProvider";

    @Override
    public void onUpdate(Context context,
                         AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        Special foodItem = new Special(R.string.pizza, R.drawable.pizza);
        int imageId = foodItem.getImageId();
        String foodName = context.getString(foodItem.getNameId());

        for (int widgetId : appWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(
                    context.getPackageName(), R.layout.widget_layout);
            remoteViews.setTextViewText(R.id.food_name, foodName);
            remoteViews.setImageViewResource(R.id.food_image, imageId);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);

        }

    }
}
