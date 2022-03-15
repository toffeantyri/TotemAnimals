package com.totems.totemanimals.view.mainAdapters

import android.util.Log
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.Utils.init

class PieValueSelect() : OnChartValueSelectedListener , DiagramListener {
    override var enteryValue: Float? = 0.0F
    set(value) {Log.d("MyLog", "$enteryValue -> $value")
        field = value }


    override fun onValueSelected(p0: Entry?, p1: Highlight?) {
        Log.d("MyLog", "Entry: x: ${p0?.x.toString()}    y:  ${p0?.y.toString()}")
        enteryValue = p0?.y
    }
    override fun onNothingSelected() {
        Log.d("MyLog", "OnNothingSelected")
    }

}