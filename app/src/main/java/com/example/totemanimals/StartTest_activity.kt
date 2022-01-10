package com.example.totemanimals

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.totemanimals.list_resours.imIdList
import kotlinx.android.synthetic.main.activity_start_test_activity.*

class StartTest_activity : BaseActivity_ApComAct() {

    var test_res_list = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_test_activity)
        var result_Test_Num: Int


        val butText = intent.getStringExtra("newtest")
        addCountAnimallist()
        // добавляем в test_res_list - количество желементов равное количеству элементов массива в list_resours
        Log.d("MyLog", "OnCreate StartTest_activity \n" + test_res_list.toString())

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

    fun addCountAnimallist() {
        val num = imIdList.count()
        var i = 0
        while (i<num) {
            test_res_list.add(0)
            i++     }
            }
}
