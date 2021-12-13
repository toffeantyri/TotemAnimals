package com.example.totemanimals

import android.animation.Animator
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener

class Animations {


    fun anim_menu_up_down(view1:View){
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
