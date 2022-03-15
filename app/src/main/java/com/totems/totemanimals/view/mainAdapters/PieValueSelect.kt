package com.totems.totemanimals.view.mainAdapters

import android.util.Log
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class PieValueSelect() : OnChartValueSelectedListener {
    var enteryValuesOfElement: Float? = 0f

    override fun onValueSelected(p0: Entry?, p1: Highlight?) {
        Log.d("MyLog", "Entry: x: ${p0?.x.toString()}    y:  ${p0?.y.toString()}")
        enteryValuesOfElement = p0?.y
    }

    override fun onNothingSelected() {

        Log.d("MyLog", "OnNothingSelected")
    }
}