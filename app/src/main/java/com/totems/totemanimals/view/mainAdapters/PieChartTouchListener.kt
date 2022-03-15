package com.totems.totemanimals.view.mainAdapters

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet
import com.github.mikephil.charting.listener.ChartTouchListener
import com.github.mikephil.charting.listener.OnChartGestureListener
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class PieChartTouchListener() : OnChartGestureListener {

    override fun onChartGestureStart(p0: MotionEvent?, p1: ChartTouchListener.ChartGesture?) {

    }

    override fun onChartGestureEnd(p0: MotionEvent?, p1: ChartTouchListener.ChartGesture?) {

    }

    override fun onChartLongPressed(p0: MotionEvent?) {
        Log.d("MyLog", "onChartLongPressed")
    }

    override fun onChartDoubleTapped(p0: MotionEvent?) {
        Log.d("MyLog", "onChartDoubleClick")
    }

    override fun onChartSingleTapped(p0: MotionEvent?) {
        Log.d("MyLog",  "SingleTap")

    }

    override fun onChartFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float) {
        Log.d("MyLog", "onChartFiling")
    }

    override fun onChartScale(p0: MotionEvent?, p1: Float, p2: Float) {
        Log.d("MyLog", "onChartFiling")
    }

    override fun onChartTranslate(p0: MotionEvent?, p1: Float, p2: Float) {
        Log.d("MyLog", "onChartTranslate")
    }


}