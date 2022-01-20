package com.example.totemanimals

import android.view.View

class Animations {


     fun anim_btn_ans(view: View) {



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

}
