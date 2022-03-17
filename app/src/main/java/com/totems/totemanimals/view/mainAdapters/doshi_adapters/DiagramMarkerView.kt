package com.totems.totemanimals.view.mainAdapters.doshi_adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.widget.ImageView
import android.widget.TextView
import com.github.mikephil.charting.components.IMarker
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.totems.totemanimals.R


class DiagramMarkerView(context: Context, layoutResours : Int) : MarkerView(context,layoutResours) {
    val titleView = findViewById<TextView>(R.id.tvMarkerViewTitle)
    val image = findViewById<ImageView>(R.id.ivMarkerView_image)
    val tvLelvel = findViewById<TextView>(R.id.tvMarkerViewLevel)


    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        titleView.text = "points: "+e?.y.toString()

        //todo рассчитать если меньше больше в пределах, установить картинку low, high, balance и установать текст
        image.setImageResource(R.drawable.image_btn_selector_om)
        tvLelvel.text = resources.getString(R.string.dosha_level_bal)





    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width/2)).toFloat(),(-250.0f))
    }

}