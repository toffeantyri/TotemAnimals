package com.totems.totemanimals.view.mainActivityFragments

import android.content.Intent
import android.os.Handler

import android.view.View
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import com.totems.totemanimals.R
import com.totems.totemanimals.view.StartTest_activity
import com.totems.totemanimals.viewModel.DataModelTestResult
import kotlinx.android.synthetic.main.fragment_fragment_test_result.view.*


open class StateOpenCloseFragment : Fragment() {

    open var state_op_close_res: Int = 0
    open var handler : Handler = Handler()


    fun View.arrowUpDownStateView(){
        if (state_op_close_res == 1) {
            this.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_less_black_32dp)
            this.im_arrow_down_dosh_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
        } else if (state_op_close_res == 2) {
            this.im_arrow_down_dosh_result.setImageResource(R.drawable.ic_expand_less_black_32dp)
            this.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
        } else {
            this.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
            this.im_arrow_down_dosh_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
        }
    }


    fun ScrollView.scrollToCenterView(targetView : View, addY : Int){
        handler.postDelayed({this.smoothScrollBy(0, targetView.top+addY)},10)
    }

    fun View.bindAllButtonStartTest() {
        this.btn_start_test.setOnClickListener {
            val intent = Intent(
                activity,
                StartTest_activity::class.java
            )
            intent.putExtra("new_test", "new_animaltotem_test")
            activity?.startActivityForResult(intent, 100)
        }
        this.btn_start_test_dosha.setOnClickListener {
            val intent = Intent(
                activity,
                StartTest_activity::class.java
            )
            intent.putExtra("new_test", "new_dosha_test")
            activity?.startActivityForResult(intent, 200)
        }
    }

}