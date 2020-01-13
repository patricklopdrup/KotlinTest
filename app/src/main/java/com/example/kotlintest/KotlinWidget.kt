package com.example.kotlintest

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.RemoteViews
import android.widget.TextView
import java.util.*

/**
 * Implementation of App Widget functionality.
 */

const val CLICK_ACTION = "CLICKED"

class KotlinWidget : AppWidgetProvider() {


    lateinit var widgetButton: Button
    lateinit var text: TextView

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) { // There may be multiple widgets active, so update all of them
        for(appWidgetId in appWidgetIds) {
            updateAppWidget(
                context,
                appWidgetManager,
                appWidgetId
            )
        }
//            val intent = Intent(context, KotlinWidget::class.java)
//            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
//            val views = RemoteViews(context.packageName, R.layout.kotlin_widget)
//            views.setOnClickPendingIntent(R.id.widget_button, pendingIntent)


    }

    override fun onReceive(context: Context, intent: Intent?) {
        if(CLICK_ACTION == intent?.action) {
            val appWidgetId = intent.getIntExtra("appWidgetId", 0)
            println("i onreceive")
            updateAppWidget(
                context,
                AppWidgetManager.getInstance(context),
                appWidgetId
            )
        }
        super.onReceive(context, intent)

    }


    override fun onEnabled(context: Context) { // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) { // Enter relevant functionality for when the last widget is disabled
    }

    companion object {
        fun updateAppWidget(
            context: Context, appWidgetManager: AppWidgetManager,
            appWidgetId: Int
        ) {

            val intent = Intent(context, KotlinWidget::class.java)
            intent.action = CLICK_ACTION
            intent.putExtra("appWidgetId", appWidgetId)
            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)

            val views = RemoteViews(context.packageName,
                R.layout.kotlin_widget
            )
            views.setTextViewText(R.id.widget_text_view, Random().nextInt().toString())
            views.setOnClickPendingIntent(R.id.widget_button, pendingIntent)
            println("clicked: $appWidgetId")

            appWidgetManager.updateAppWidget(appWidgetId, views)

        }
    }
}