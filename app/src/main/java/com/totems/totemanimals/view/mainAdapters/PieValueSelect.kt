package com.totems.totemanimals.view.mainAdapters

import android.util.Log
import android.view.MotionEvent
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.ChartTouchListener
import com.github.mikephil.charting.listener.OnChartGestureListener
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.Utils.init

class PieValueSelect(entryList: ArrayList<PieEntry>) : OnChartValueSelectedListener, DiagramListener {
    override var enteryValue: Float? = 0.0F
        set(value) {
            Log.d("MyLog", "init enteryValue: $enteryValue -> $value")
            field = value
        }

    val list = entryList

    override fun onValueSelected(p0: Entry?, p1: Highlight?) {
        Log.d("MyLog", "OnValueSelectedEntry: LastEntryValue ==  y:  ${p0?.y.toString()}")
        enteryValue = p0?.y
        getIndexOfClickedElement(list)
        Log.d("MyLog", "index: " + getIndexOfClickedElement(list).toString())

    }

    override fun onNothingSelected() {
        Log.d("MyLog", "OnNothingSelected")
    }


    fun getIndexOfClickedElement(entryList: ArrayList<PieEntry>) = entryList.indexOfFirst { it.value == enteryValue }

    fun constructorDoshi(indexDoshi: Int){

    }

    inner class PieChartTouchListener() : OnChartGestureListener {


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
            Log.d("MyLog", "SingleTap")
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

}
