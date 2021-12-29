package com.example.totemanimals

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start_test_activity.*

class StartTest_activity : BaseActivity_ApComAct() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_test_activity)
        val butText = intent.getStringExtra("start_test")!!

        btn_close_test.setOnClickListener{
            intent.putExtra("123", "123")
            setResult(Activity.RESULT_CANCELED,intent)
            finish()
        }
    }
}
