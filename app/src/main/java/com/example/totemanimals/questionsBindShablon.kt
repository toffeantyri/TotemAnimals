package com.example.totemanimals

import android.text.Layout
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_start_test_activity.*
import kotlinx.android.synthetic.main.activity_start_test_activity.view.*

data class questionsBindShablon(val number_q:Int, val text_q: String, val numbers_ans:Int,
                                val numbers_q: Int, val right_answer_act: Array<Array<Int>>, val name_buttons: Array<String>,val min_nums_ans: Int) {
val anim_var = Animations()

    fun bindingView (view: View) {
        val index0 = (number_q+1).toString()
        val nums0 = numbers_q.toString()

        view.tv_num_quest.text = index0 + "/" + nums0
        view.tv_text_quest.text = text_q
        when(numbers_ans) {
            in 11..15 -> {view.btn_column1.visibility =View.VISIBLE
                view.btn_column2.visibility =View.VISIBLE
                view.btn_column3.visibility =View.VISIBLE
                when(numbers_ans){
                    11 -> {view.btn_ans12.visibility = View.GONE
                        view.btn_ans13.visibility = View.GONE
                        view.btn_ans14.visibility = View.GONE
                        view.btn_ans15.visibility = View.GONE}
                    12 -> {view.btn_ans13.visibility = View.GONE
                        view.btn_ans14.visibility = View.GONE
                        view.btn_ans15.visibility = View.GONE}
                    13 -> {view.btn_ans14.visibility = View.GONE
                        view.btn_ans15.visibility = View.GONE}
                    14 -> {view.btn_ans15.visibility = View.GONE}
                    15 -> {}
                }
            }

            in 6..10 -> {view.btn_column1.visibility =View.VISIBLE
                view.btn_column2.visibility =View.VISIBLE
                view.btn_column3.visibility =View.GONE
                when(numbers_ans) {
                    6 -> {view.btn_ans7.visibility = View.GONE
                        view.btn_ans8.visibility = View.GONE
                        view.btn_ans9.visibility = View.GONE
                        view.btn_ans10.visibility = View.GONE}
                    7 -> {view.btn_ans8.visibility = View.GONE
                        view.btn_ans9.visibility = View.GONE
                        view.btn_ans10.visibility = View.GONE }
                    8 -> {view.btn_ans9.visibility = View.GONE
                        view.btn_ans10.visibility = View.GONE}
                    9 -> {view.btn_ans10.visibility = View.GONE}
                    10 -> {}
                }
            }

            in 1..5 -> {view.btn_column1.visibility =View.VISIBLE
                when(numbers_ans) {
                    1 -> { view.btn_ans2.visibility = View.GONE
                        view.btn_ans3.visibility = View.GONE
                        view.btn_ans4.visibility = View.GONE
                        view.btn_ans5.visibility = View.GONE}

                    2 -> {  view.btn_ans3.visibility = View.GONE
                        view.btn_ans4.visibility = View.GONE
                        view.btn_ans5.visibility = View.GONE }

                    3 -> {view.btn_ans4.visibility = View.GONE
                        view.btn_ans5.visibility = View.GONE}

                    4 -> {view.btn_ans5.visibility = View.GONE}

                    5 -> {}
                }


                view.btn_column2.visibility =View.GONE
                view.btn_column3.visibility =View.GONE
            }

            else -> {view.btn_column1.visibility =View.GONE
                view.btn_column2.visibility =View.GONE
                view.btn_column3.visibility =View.GONE}

        }


    }

    fun resetBindView (view: View){
        view.btn_close_testfor_result.visibility=View.GONE
        view.btn_column1.visibility=View.GONE
        view.btn_column1.visibility=View.GONE
        view.btn_column1.visibility=View.GONE

        view.btn_ans1.visibility=View.VISIBLE
        view.btn_ans2.visibility=View.VISIBLE
        view.btn_ans3.visibility=View.VISIBLE
        view.btn_ans4.visibility=View.VISIBLE
        view.btn_ans5.visibility=View.VISIBLE
        view.btn_ans6.visibility=View.VISIBLE
        view.btn_ans7.visibility=View.VISIBLE
        view.btn_ans8.visibility=View.VISIBLE
        view.btn_ans9.visibility=View.VISIBLE
        view.btn_ans10.visibility=View.VISIBLE
        view.btn_ans11.visibility=View.VISIBLE
        view.btn_ans12.visibility=View.VISIBLE
        view.btn_ans13.visibility=View.VISIBLE
        view.btn_ans14.visibility=View.VISIBLE
        view.btn_ans15.visibility=View.VISIBLE

        anim_var.reset_anim_btn_ans(view.btn_ans1)
        anim_var.reset_anim_btn_ans(view.btn_ans2)
        anim_var.reset_anim_btn_ans(view.btn_ans3)
        anim_var.reset_anim_btn_ans(view.btn_ans4)
        anim_var.reset_anim_btn_ans(view.btn_ans5)
        anim_var.reset_anim_btn_ans(view.btn_ans6)
        anim_var.reset_anim_btn_ans(view.btn_ans7)
        anim_var.reset_anim_btn_ans(view.btn_ans8)
        anim_var.reset_anim_btn_ans(view.btn_ans9)
        anim_var.reset_anim_btn_ans(view.btn_ans10)
        anim_var.reset_anim_btn_ans(view.btn_ans11)
        anim_var.reset_anim_btn_ans(view.btn_ans12)
        anim_var.reset_anim_btn_ans(view.btn_ans13)
        anim_var.reset_anim_btn_ans(view.btn_ans14)
        anim_var.reset_anim_btn_ans(view.btn_ans15)

    }

    fun bindNameBtn(view: View) {
        val name_btn: Array<String> = name_buttons

        view.btn_ans1.text = name_btn[0]
        view.btn_ans2.text = name_btn[1]
        view.btn_ans3.text = name_btn[2]
        view.btn_ans4.text = name_btn[3]
        view.btn_ans5.text = name_btn[4]
        view.btn_ans6.text = name_btn[5]
        view.btn_ans7.text = name_btn[6]
        view.btn_ans8.text = name_btn[7]
        view.btn_ans9.text = name_btn[8]
        view.btn_ans10.text = name_btn[9]
        view.btn_ans11.text = name_btn[10]
        view.btn_ans12.text = name_btn[11]
        view.btn_ans13.text = name_btn[12]
        view.btn_ans14.text = name_btn[13]
        view.btn_ans15.text = name_btn[14]
    }


}

data class resultBindShablon (val index: Int, val right_answer_act: Array<Array<Int>>,val min_nums_answ: Int) {

    fun bindAction(id_btn:Int, list_result: Array<Int>,): Array<Int> {
        Log.d("MyLog", "  in res " + list_result.contentToString())

        val list_result0 = list_result
        val right_answer_list = right_answer_act[id_btn-1]
        Log.d("MyLog", "\n mid res " + right_answer_list.contentToString())

            var num = 0
            for (i in right_answer_list) {
                list_result0[num] = list_result0[num] + i
                num++
            }

        Log.d("MyLog", "\n res res " + list_result0.contentToString() )
        return list_result0
    }


}