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

    lateinit var test_res_list: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_test_activity)
        Log.d("MyLog", "OnCreate StartTest_activity")

        test_res_list = Array<Int>(imIdList.count(),{0})
        Log.d("MyLog","Список для результатов"+test_res_list.contentToString())
        //создаем массив наполненый колчеством 0 равный размеру вариантов результата теста(количество животных)


        var index = 0
        testNextQuestion(index)

        btn_ans1.setOnClickListener {
            Log.d("MyLog", "btn1")
            index++
            testNextQuestion(index)

        }
        btn_ans2.setOnClickListener {
            Log.d("MyLog", "btn2")
            index++
            testNextQuestion(index)
        }
        btn_ans3.setOnClickListener {
            Log.d("MyLog", "btn3")
            index++
            testNextQuestion(index)
        }
        btn_ans4.setOnClickListener {
            Log.d("MyLog", "btn4")
            index++
            testNextQuestion(index)
        }
        btn_ans5.setOnClickListener {
            Log.d("MyLog", "btn5")
            index++
            testNextQuestion(index)
        }
        btn_ans6.setOnClickListener {
            Log.d("MyLog", "btn6")
            index++
            testNextQuestion(index)
        }
        btn_ans7.setOnClickListener {
            Log.d("MyLog", "btn7")
            index++
            testNextQuestion(index)
        }
        btn_ans8.setOnClickListener {
            Log.d("MyLog", "btn8")
            index++
            testNextQuestion(index)
        }
        btn_ans9.setOnClickListener {
            Log.d("MyLog", "btn9")
            index++
            testNextQuestion(index)
        }
        btn_ans10.setOnClickListener {
            Log.d("MyLog", "btn10")
            index++
            testNextQuestion(index)
        }
        btn_ans11.setOnClickListener {
            Log.d("MyLog", "btn11")
            index++
            testNextQuestion(index)
        }
        btn_ans12.setOnClickListener {
            Log.d("MyLog", "btn12")
            index++
            testNextQuestion(index)
        }
        btn_ans13.setOnClickListener {
            Log.d("MyLog", "btn13")
            index++
            testNextQuestion(index)
        }
        btn_ans14.setOnClickListener {
            Log.d("MyLog", "btn14")
            index++
            testNextQuestion(index)
        }
        btn_ans15.setOnClickListener {
            Log.d("MyLog", "btn15")
            index++
            testNextQuestion(index)
        }






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

    }



    fun constructorQuestObj (index: Int, list_quest: Array<String>, list_nums_ans: Array<Int>,
                             list_right_answer: Array<Array<Array<Int>>>, list_name_btn: Array<Array<String>>) : questionsBindShablon {
        val number_q: Int = index
        val text_q: String = list_quest[index]
        val numbers_ans: Int = list_nums_ans[index]
        val numbers_q: Int = list_quest.count()
        val right_answer_act = list_right_answer[index]
        val name_btn = list_name_btn[index]
        return questionsBindShablon(number_q, text_q, numbers_ans,numbers_q,right_answer_act, name_btn)
    }


    fun testNextQuestion (index: Int) {
        Log.d("MyLog","$index")
        val view : View = findViewById(R.id.layout_test)
        val list_of_quest = questionListsTotemAnimal.quest_totem_animal
        val list_of_nums_answer = questionListsTotemAnimal.answer_num
        val list_right_answer = questionListsTotemAnimal.answer_right_check
        val list_butt_name = questionListsTotemAnimal.button_name_list

        if (index < questionListsTotemAnimal.quest_totem_animal.count()) {
            val shablon = constructorQuestObj(index,list_of_quest,list_of_nums_answer,list_right_answer,list_butt_name)
            shablon.resetBindView(view)
            shablon.bindingView(view)
            shablon.bindNameBtn(view)

                        }
        else {
            Log.d("MyLog", "End test no view bind")
            }
    }

}

