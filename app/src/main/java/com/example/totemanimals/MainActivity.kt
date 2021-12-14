package com.example.totemanimals

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
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

    fun onClickExitButton (view: View) {
        buttonEffectonClick(menu_bt_exit)
        finishAndRemoveTask()
                    }

    fun onClickInfo(view: View){
        buttonEffectonClick(menu_bt_info)
    }

    fun onClickSearchList(view: View){
        buttonEffectonClick(menu_bt_searchlist)
    }

    fun onClickMyTest(view: View){
        buttonEffectonClick(menu_bt_my_test)
    }
}

