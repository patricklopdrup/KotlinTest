package com.example.kotlintest.Widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.RemoteViews
import com.example.kotlintest.MainActivity
import com.example.kotlintest.R

/**
 * Implementation of App Widget functionality.
 */
class NewWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) { // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {

            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

            val serviceIntent = Intent(context, WidgetService::class.java)
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            //if this was not here and we had more than one widget on the homescreen they would get the same appWidgetId
            serviceIntent.data = Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME))

            val views = RemoteViews(context.packageName, R.layout.new_widget)
            views.setRemoteAdapter(R.id.widget_stack_view, serviceIntent)
            views.setEmptyView(
                R.id.widget_stack_view,
                R.id.widget_empty_view
            )


            appWidgetManager.updateAppWidget(appWidgetId, views)

            //updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onAppWidgetOptionsChanged(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetId: Int,
        newOptions: Bundle?
    ) {
        //val views = RemoteViews(context?.packageName, R.layout.new_widget)
    }

    override fun onEnabled(context: Context) { // Enter relevant functionality for when the first widget is created
        println("jeg er enabled")
    }

    override fun onDisabled(context: Context) { // Enter relevant functionality for when the last widget is disabled
        println("jeg er disabled")
    }

//    companion object {
//        fun updateAppWidget(
//            context: Context, appWidgetManager: AppWidgetManager,
//            appWidgetId: Int
//        ) { // Construct the RemoteViews object
//            val views = RemoteViews(context.packageName, R.layout.new_widget)
//            // Instruct the widget manager to update the widget
//            appWidgetManager.updateAppWidget(appWidgetId, views)
//        }
//    }
}