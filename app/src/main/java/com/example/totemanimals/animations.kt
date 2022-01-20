package com.example.totemanimals


import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import kotlinx.android.synthetic.main.fragment_fragment_test_result.view.*


class Animations {


     fun anim_btn_ans(view: View) { //Анимация для кнопок ответа

         view.animate().apply {
             duration = 1000
             scaleX(1.5f)
             scaleY(1.5f)

             alpha(0.1f)
         }.withEndAction {
             view.animate().apply {
                 duration = 0
                 scaleX(1f)
                 scaleY(1f)
                 alpha(1f)
             }.start()
         }
     }

    fun anim_Testresult(view: View) {
        view.animate().apply {
            duration = 150
            scaleY(1.3f)
            scaleX(1.3f)

            rotationY(45f)
        }.withEndAction {
            view.animate().apply {
                duration=100
                scaleX(1f)
                scaleY(1f)

                rotationY(0f)
            }
        }
        }
    }

