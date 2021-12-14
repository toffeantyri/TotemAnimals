package com.example.totemanimals

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }





    fun onClickOpenMenu(view: View) {
        buttonEffectonClick(btn_open_menu)
        val menuOpenClose = Animations()
        menuOpenClose.anim_menu_up_down(frame_menu,btn_open_menu)
        if (frame_menu.visibility==View.VISIBLE) {btn_open_menu.setImageResource(R.drawable.ic_expand_more_black_32dp)}
        else {btn_open_menu.setImageResource(R.drawable.ic_expand_less_black_32dp)}
    }

    fun buttonEffectonClick(imageButton: View) {
        imageButton.setOnTouchListener{
            v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {v.background.setColorFilter(-0x1f0b8adf, PorterDuff.Mode.SRC_ATOP)
                v.invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    v.background.clearColorFilter()
                    v.invalidate()
                }
            }
            false
        }
    }




}

