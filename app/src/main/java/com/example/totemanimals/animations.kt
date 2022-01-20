package com.example.totemanimals

import android.animation.Animator
import android.app.Notification
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference
import java.util.logging.Handler

class Animations {


     fun anim_btn_ans(view: View) {

        view.animate().apply {
            duration=1000
            alpha(0f)
                    }.withEndAction {
            view.animate().apply {
                duration = 0
                alpha(1f)
            }.start()
        }

    }


    fun anim_menu_up_down(view1:View,view2:View){
        val menuState = view1.visibility
        if (menuState==View.GONE) {
            view1.animate().apply {
                view1.visibility=View.VISIBLE
                duration=0
                alpha(0f)
                translationY(75f)
            }.withEndAction {
                view1.animate().apply {
                    duration=500
                    alpha(1f)
                    translationY(0f)    }
            }.start()
        }

            else {
            view1.animate().apply {
            duration=0
            alpha(1f)
            translationY(0f)
                }.withEndAction {
            view1.animate().apply {
                duration=500
                alpha(0f)
                translationY(75f)          }
        }.start()
        view1.visibility=View.GONE}

    }

}
