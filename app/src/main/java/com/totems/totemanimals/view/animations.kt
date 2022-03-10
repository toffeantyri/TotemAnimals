package com.totems.totemanimals.view


import android.view.View


class Animations {


    fun anim_btn_ans(view: View) { //Анимация для кнопок ответа

        view.animate().apply {
            duration = 800
            scaleX(0.4f)
            scaleY(0.4f)
            alpha(0.6f)
            view.isClickable = false
        }.start()
    }

    fun reset_anim_btn_ans(view: View) { //Анимация для кнопок ответа
        view.animate().apply {
            duration = 0
            scaleX(1f)
            scaleY(1f)
            alpha(1f)
            view.isClickable = true
        }.start()
    }

    fun anim_Testresult(view: View) {
        view.animate().apply {
            duration = 150
            scaleY(1.4f)
            scaleX(1.4f)
            rotationY(45f)
        }.withEndAction {
            view.animate().apply {
                duration = 100
                scaleX(1f)
                scaleY(1f)
                rotationY(0f)
            }
        }
    }

    fun down_result (view: View) {
        view.animate().apply {
            duration = 0
            scaleY(0f)
            translationY(-600f)
        }.withEndAction {
            view.animate().apply {
                duration = 150
                scaleY(1f)
                translationY(0f)
            }
        }
    }


}




