package com.example.totemanimals

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.preference.PreferenceManager
import com.example.totemanimals.list_resours.imIdList
import kotlinx.android.synthetic.main.activity_start_test_activity.*
import kotlinx.android.synthetic.main.activity_start_test_activity.view.*

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
            resultUpdate(1,index)
            index++
            testNextQuestion(index)        }

        btn_ans2.setOnClickListener {
            Log.d("MyLog", "btn2")
            resultUpdate(2,index)
            index++
            testNextQuestion(index)        }

        btn_ans3.setOnClickListener {
            resultUpdate(3,index)
            Log.d("MyLog", "btn3")
            index++
            testNextQuestion(index)        }

        btn_ans4.setOnClickListener {
            Log.d("MyLog", "btn4")
            resultUpdate(4,index)
            index++
            testNextQuestion(index)        }

        btn_ans5.setOnClickListener {
            Log.d("MyLog", "btn5")
            resultUpdate(5,index)
            index++
            testNextQuestion(index)        }

        btn_ans6.setOnClickListener {
            Log.d("MyLog", "btn6")
            resultUpdate(6,index)
            index++
            testNextQuestion(index)        }

        btn_ans7.setOnClickListener {
            Log.d("MyLog", "btn7")
            resultUpdate(7,index)
            index++
            testNextQuestion(index)        }

        btn_ans8.setOnClickListener {
            Log.d("MyLog", "btn8")
            resultUpdate(8,index)
            index++
            testNextQuestion(index)        }

        btn_ans9.setOnClickListener {
            Log.d("MyLog", "btn9")
            resultUpdate(9,index)
            index++
            testNextQuestion(index)        }

        btn_ans10.setOnClickListener {
            Log.d("MyLog", "btn10")
            resultUpdate(10,index)
            index++
            testNextQuestion(index)        }

        btn_ans11.setOnClickListener {
            Log.d("MyLog", "btn11")
            resultUpdate(11,index)
            index++
            testNextQuestion(index)        }

        btn_ans12.setOnClickListener {
            Log.d("MyLog", "btn12")
            resultUpdate(12,index)
            index++
            testNextQuestion(index)        }

        btn_ans13.setOnClickListener {
            Log.d("MyLog", "btn13")
            resultUpdate(13,index)
            index++
            testNextQuestion(index)        }

        btn_ans14.setOnClickListener {
            Log.d("MyLog", "btn14")
            resultUpdate(14,index)
            index++
            testNextQuestion(index)        }

        btn_ans15.setOnClickListener {
            Log.d("MyLog", "btn15")
            resultUpdate(15,index)
            index++
            testNextQuestion(index)        }

        btn_close_testfor_result.setOnClickListener {
            val first_max_name = MinMaxMaxTwoResult()[0]
            val first_max_volume = MinMaxMaxTwoResult()[1]
            val second_max_name = MinMaxMaxTwoResult()[2]
            val second_max_volume = MinMaxMaxTwoResult()[3]
            val last_min_name = MinMaxMaxTwoResult()[4]
            val last_min_volume = MinMaxMaxTwoResult()[5]

            val pref = PreferenceManager.getDefaultSharedPreferences(this)
            pref.edit().putInt("first_name",first_max_name).apply()
            pref.edit().putInt("first_volume",first_max_volume).apply()
            pref.edit().putInt("second_name",second_max_name).apply()
            pref.edit().putInt("second_volume",second_max_volume).apply()
            pref.edit().putInt("last_name",last_min_name).apply()
            pref.edit().putInt("last_volume",last_min_volume).apply()

            intent.putExtra("first_name", first_max_name )
            intent.putExtra("first_volume", first_max_volume)
            intent.putExtra("second_name", second_max_name)
            intent.putExtra("second_volume", second_max_volume)
            intent.putExtra("last_name", last_min_name)
            intent.putExtra("last_volume", last_min_volume)
            setResult(Activity.RESULT_OK,intent)
        finish()
        }

        btn_close_test.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        result1_test_btnh.setOnClickListener {
            //todo тест приема
            //test_res_list = arrayOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14)
            val new_results = MinMaxMaxTwoResult()
            Log.d("MyLog", new_results.contentToString())
            Log.d("MyLog", test_res_list.contentToString())


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

    fun constructorResultBindShablon (index: Int, list_right_answer: Array<Array<Array<Int>>>,) : resultBindShablon {
        return resultBindShablon(index, list_right_answer[index])
    }


    fun testNextQuestion (index: Int) {
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
            view.btn_close_testfor_result.visibility=View.VISIBLE
            view.btn_column1.visibility=View.GONE
            view.btn_column2.visibility=View.GONE
            view.btn_column3.visibility=View.GONE
            view.btn_close_test.visibility=View.GONE
            view.tv_text_quest.text=getString(R.string.measuring_result)

            }
    }


    fun resultUpdate (btn_id:Int, index: Int){
        val list_right_answer = questionListsTotemAnimal.answer_right_check
        if(index < questionListsTotemAnimal.quest_totem_animal.count()-1) {
            val shablonResultUpdater = constructorResultBindShablon(index,list_right_answer)
            test_res_list = shablonResultUpdater.bindAction(btn_id,test_res_list)
                    }
        else {Log.d("MyLog", "End Result \n" + test_res_list.contentToString() )


        }

    }

    fun MinMaxMaxTwoResult () : Array<Int> { // находит из массива результатов

        val min_volume : Int = test_res_list.minByOrNull{it} ?: -1
        val min_name : Int = if(min_volume>=0) test_res_list.indexOf(min_volume) else -1
        val max_volume : Int = test_res_list.maxByOrNull{it} ?: -1
        val max_name : Int = if(max_volume>=0) test_res_list.indexOf(max_volume) else -1
        test_res_list[max_name] = -1
        val s_max_volume : Int = test_res_list.maxByOrNull{it} ?: -1
        val s_max_name : Int = if(s_max_volume>=0) test_res_list.indexOf(s_max_volume) else -1
        test_res_list[max_name]=max_volume
        return arrayOf(max_name,max_volume,s_max_name,s_max_volume,min_name,min_volume)

    }

}

