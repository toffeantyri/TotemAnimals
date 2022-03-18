package com.totems.totemanimals.view.mainAdapters.doshi_adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import com.github.mikephil.charting.components.IMarker
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.totems.totemanimals.R
import com.totems.totemanimals.resoursesTests.List_Resours_Doshi.BALANCE_LEVEL_MAX
import com.totems.totemanimals.resoursesTests.List_Resours_Doshi.BALANCE_LEVEL_MIN


class DiagramMarkerView(context: Context, layoutResours: Int) : MarkerView(context, layoutResours) {
    val titleView = findViewById<TextView>(R.id.tvMarkerViewTitle)
    val image = findViewById<ImageView>(R.id.ivMarkerView_image)
    val tvLelvel = findViewById<TextView>(R.id.tvMarkerViewLevel)


    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        titleView.text = e?.let { entryOfMaxPoint(it) }
        tvLelvel.text = e?.let { textOfLevelDesc(it) }
        e?.let { tvLelvel.textColorOfLevelDesc(it) }
        e?.let { image.imageOfLevel(e) }


    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-250.0f))
    }

    private fun entryOfMaxPoint(e: Entry): String = resources.getString(R.string.dosha_level) + " : " + e.y.toString()

    private fun ImageView.imageOfLevel(e: Entry) {
        when {
            e.y in BALANCE_LEVEL_MIN..BALANCE_LEVEL_MAX -> this.setImageResource(R.drawable.image_btn_selector_om)
            e.y < BALANCE_LEVEL_MIN -> this.setImageResource(R.drawable.ic_arrow_low_24dp)
            e.y > BALANCE_LEVEL_MAX -> this.setImageResource(R.drawable.ic_arrow_high_24dp)
        }
    }

    private fun textOfLevelDesc(e: Entry): String {
        when {
            e.y in BALANCE_LEVEL_MIN..BALANCE_LEVEL_MAX -> return resources.getString(R.string.dosha_level_bal)
            e.y < BALANCE_LEVEL_MIN -> return resources.getString(R.string.dosha_level_l)
            e.y > BALANCE_LEVEL_MAX -> return resources.getString(R.string.dosha_level_h)
        }
        return ""
    }

    private fun TextView.textColorOfLevelDesc(e: Entry) {
        when {
            e.y in BALANCE_LEVEL_MIN..BALANCE_LEVEL_MAX -> return this.setTextColor(resources.getColor(R.color.result_green))
            e.y < BALANCE_LEVEL_MIN -> return this.setTextColor(resources.getColor(R.color.result_yellow))
            e.y > BALANCE_LEVEL_MAX -> return this.setTextColor(resources.getColor(R.color.red_btn))
        }

    }


}