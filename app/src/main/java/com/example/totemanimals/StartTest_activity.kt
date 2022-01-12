package com.example.totemanimals

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.totemanimals.list_resours.imIdList
import kotlinx.android.synthetic.main.activity_start_test_activity.*

class StartTest_activity : BaseActivity_ApComAct() {

    var test_res_list = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_test_activity)
        //val butText = intent.getStringExtra("newtest") // надо ли получить что бы request code был правильный
        addCountAnimallist()
        // добавляем в test_res_list - количество желементов равное количеству элементов массива в list_resours
        Log.d("MyLog", "OnCreate StartTest_activity \n лист результатов" + test_res_list.toString())

        result1_test_btnh.setOnClickListener{
                intent.putExtra("result_test", "Белочка" )
                intent.putExtra("result_test_int", 0 )
                intent.putExtra("result_test_volume", test_res_list[0] )
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

        result2_test_btn.setOnClickListener{
                intent.putExtra("result_test", "Боберчик")
                intent.putExtra("result_test_int", 1 )
            intent.putExtra("result_test_volume", test_res_list[1] )
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

        result3_test_btn.setOnClickListener{
                intent.putExtra("result_test", "Йожик")
                intent.putExtra("result_test_int", 2 )
            intent.putExtra("result_test_volume", test_res_list[2] )
            setResult(Activity.RESULT_OK,intent)
            finish()
        }


        btn_close_test.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }


        bindViewTest(2,13)
    }

    fun addCountAnimallist() {
        val num = imIdList.count()
        var i = 0
        while (i<num) {
            test_res_list.add(0)
            i++     }
            }

    fun bindViewTest(index:Int, nums: Int) {
        val index0 = (index +1).toString()
        val nums0 = nums.toString()

        tv_num_quest.text = index0 + "/" + nums0
        tv_text_quest.text = questionListsTotemAnimal.quest_totem_animal[index]
        when(questionListsTotemAnimal.answer_num[index]) {
            in 11..15 -> {btn_column1.visibility =View.VISIBLE
                         btn_column2.visibility =View.VISIBLE
                         btn_column3.visibility =View.VISIBLE
                when(questionListsTotemAnimal.answer_num[index]){
                    11 -> {btn_ans12.visibility = View.GONE
                        btn_ans13.visibility = View.GONE
                        btn_ans14.visibility = View.GONE
                        btn_ans15.visibility = View.GONE}
                    12 -> {btn_ans13.visibility = View.GONE
                        btn_ans14.visibility = View.GONE
                        btn_ans15.visibility = View.GONE}
                    13 -> {btn_ans14.visibility = View.GONE
                            btn_ans15.visibility = View.GONE}
                    14 -> {btn_ans15.visibility = View.GONE}
                    15 -> {}
                }
            }

            in 6..10 -> {btn_column1.visibility =View.VISIBLE
                        btn_column2.visibility =View.VISIBLE
                        btn_column3.visibility =View.GONE
                when(questionListsTotemAnimal.answer_num[index]) {
                    6 -> {btn_ans7.visibility = View.GONE
                            btn_ans8.visibility = View.GONE
                            btn_ans9.visibility = View.GONE
                            btn_ans10.visibility = View.GONE}
                    7 -> {btn_ans8.visibility = View.GONE
                        btn_ans9.visibility = View.GONE
                        btn_ans10.visibility = View.GONE }
                    8 -> {btn_ans9.visibility = View.GONE
                            btn_ans10.visibility = View.GONE}
                    9 -> {btn_ans10.visibility = View.GONE}
                    10 -> {}
                }
            }

            in 1..5 -> {btn_column1.visibility =View.VISIBLE
                when(questionListsTotemAnimal.answer_num[index]) {
                    1 -> {  btn_ans2.visibility = View.GONE
                            btn_ans3.visibility = View.GONE
                            btn_ans4.visibility = View.GONE
                            btn_ans5.visibility = View.GONE}

                    2 -> {   btn_ans3.visibility = View.GONE
                             btn_ans4.visibility = View.GONE
                             btn_ans5.visibility = View.GONE }

                    3 -> {btn_ans4.visibility = View.GONE
                        btn_ans5.visibility = View.GONE}

                    4 -> {btn_ans5.visibility = View.GONE}

                    5 -> {}
                }


                        btn_column2.visibility =View.GONE
                        btn_column3.visibility =View.GONE
            }

            else -> {btn_column1.visibility =View.GONE
                     btn_column2.visibility =View.GONE
                     btn_column3.visibility =View.GONE}

        }


        }

}

