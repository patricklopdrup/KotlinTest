package com.example.kotlintest.Widget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.kotlintest.R

class WidgetService: RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        println("i onGetViewFactory")
        return WidgetItemFactory(
            applicationContext,
            intent!!
        )
    }

    class WidgetItemFactory: RemoteViewsFactory {

        var context: Context
        var appWidgetId: Int = 0
        var dataTitle = arrayOf("hej", "test", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9")
        var dataDesc = arrayOf("hej desc", "test", "test2 desc", "test3 desc", "test4 desc", "test5", "test6", "test7", "test8", "test9")

        constructor(context: Context, intent: Intent) {
            this.context = context
            this.appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID)
        }

        override fun onCreate() {
            println("onCreate bliver kaldt")
            //connect to data source. Get the data
        }

        override fun getLoadingView(): RemoteViews? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun onDataSetChanged() {

        }

        override fun hasStableIds(): Boolean {
            return true
        }

        override fun getViewAt(p0: Int): RemoteViews {
            println("getViewAt bliver kaldt")
            val views = RemoteViews(context.packageName,
                R.layout.widget_item
            )
            views.setTextViewText(R.id.widget_item_title, dataTitle[p0])
            views.setTextViewText(R.id.widget_item_desc, dataDesc[p0])
            return views
        }

        override fun getCount(): Int {
            return dataTitle.size
        }

        override fun getViewTypeCount(): Int {
            return 1
        }

        override fun onDestroy() {

        }

    }

}