package jp.numero.dynamiccolorpreview

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class ColorPreviewAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
    }

    override fun onDisabled(context: Context) {
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val items = listOf(
        R.layout.app_widget_color_preview_primary,
        R.layout.app_widget_color_preview_primary_dark,
        R.layout.app_widget_color_preview_accent,
        R.layout.app_widget_color_preview_background,
        R.layout.app_widget_color_preview_foreground,
        R.layout.app_widget_color_preview_text_primary,
        R.layout.app_widget_color_preview_text_secondary,
    )

    val views = RemoteViews(context.packageName, R.layout.color_preview_app_widget)
    views.setRemoteAdapter(
        R.id.colorPreviewList,
        with(RemoteViews.RemoteCollectionItems.Builder()) {
            items.forEachIndexed { index, layout ->
                addItem(index.toLong(), RemoteViews(context.packageName, layout))
            }
            setHasStableIds(true)
            setViewTypeCount(items.count())
            build()
        }
    )

    appWidgetManager.updateAppWidget(appWidgetId, views)
}