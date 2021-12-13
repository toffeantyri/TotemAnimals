package com.example.totemanimals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }




    fun onClickOpenMenu(view: View) {
        val menuOpenClose = Animations()
        //val frameMenu = findViewById<View>(R.id.frame_menu)
        menuOpenClose.anim_menu_up_down(frame_menu)
        if (frame_menu.visibility==View.VISIBLE) {btn_open_menu.setImageResource(R.drawable.ic_expand_less_black_32dp)}
        else {btn_open_menu.setImageResource(R.drawable.ic_expand_more_black_32dp)}
    }
}

