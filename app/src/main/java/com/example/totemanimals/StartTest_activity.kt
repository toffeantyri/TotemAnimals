package com.example.totemanimals

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_start_test_activity.*

class StartTest_activity : BaseActivity_ApComAct() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_test_activity)
        var result_Test_Num: Int

        val butText = intent.getStringExtra("newtest")!!
        Log.d("MyLog",butText)

        result1_test_btnh.setOnClickListener{
                intent.putExtra("result_test", "Хорек" )
                intent.putExtra("result_test_int", 0 )
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

        result2_test_btn.setOnClickListener{
                intent.putExtra("result_test", "Жук")
                intent.putExtra("result_test_int", 1 )
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

        result3_test_btn.setOnClickListener{
                intent.putExtra("result_test", "Козочка")
                intent.putExtra("result_test_int", 2 )
            setResult(Activity.RESULT_OK,intent)
            finish()
        }


        btn_close_test.setOnClickListener{
            //intent.putExtra("close", "test closed")
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
