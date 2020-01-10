package com.example.kotlintest;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class WidgetJavaTest extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for(int appWidget: appWidgetIds) {
            Intent serviceIntent = new Intent(context, MainActivity.class);
        }

        String[] dataTitles = new String[] {"hej", "test", "yeet", "dav", "dååm"};


    }
}
