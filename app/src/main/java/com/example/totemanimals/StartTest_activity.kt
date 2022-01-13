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

        addCountAnimallist(imIdList)
        // добавляем в test_res_list - количество элементов (нулей) равное количеству элементов массива в list_resours

        Log.d("MyLog", "OnCreate StartTest_activity \n лист результатов" + test_res_list.toString()
                + "\n Count =" + test_res_list.count())


        testStart()







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

    fun addCountAnimallist(list_q: List<Int>) {
        val num = list_q.count()
        var i = 0
        while (i<num) {
            test_res_list.add(0)
            i++     }
            }

    fun constructorQuestObj (index: Int, list_quest: List<String>, list_nums_ans: List<Int>, list_right_answer: List<List<Int>>) : questionsBindShablon {
        val number_q: Int = index+1
        val text_q: String = list_quest[index]
        val numbers_ans: Int = list_nums_ans[index]
        val numbers_q: Int = list_quest.count()
        val right_answer_act = list_right_answer[index]
        return questionsBindShablon(number_q, text_q, numbers_ans,numbers_q,right_answer_act)
    }

    fun testStart () {
        val view : View = findViewById(R.id.layout_test)
        var i = 0
        val list_of_quest = questionListsTotemAnimal.quest_totem_animal
        val list_of_nums_answer = questionListsTotemAnimal.answer_num
        val list_right_answer = questionListsTotemAnimal.answer_right_check
        while (i < questionListsTotemAnimal.quest_totem_animal.count()) {
            val shablon = constructorQuestObj(i,list_of_quest,list_of_nums_answer,list_right_answer)
            shablon.resetBindView(view)
            shablon.bindingView(view)
            shablon.bindAnsAction(view) // в процессе написания




            i++
        }
    }

}

