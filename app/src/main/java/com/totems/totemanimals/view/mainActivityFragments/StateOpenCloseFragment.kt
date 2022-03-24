package com.totems.totemanimals.view.mainActivityFragments

import android.content.Intent
import android.os.Handler

import android.view.View
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.totems.totemanimals.R
import com.totems.totemanimals.StartTest_activity
import com.totems.totemanimals.viewModel.DataModelTestResult
import kotlinx.android.synthetic.main.fragment_fragment_test_result.view.*


open class StateOpenCloseFragment : Fragment() {

    open var state_op_close_res: Int = 0
    open var handler : Handler = Handler()

    fun View.tvNoResultsVisibility(first_name_animal: Int, any_dosha: Int) {
        this.apply {
            tv_no_results.visibility = if (first_name_animal == -1) {
                View.VISIBLE
            } else {
                View.GONE
            }

            tv_no_results_dosha.visibility = if (any_dosha == -1) {
                View.VISIBLE
            } else {
                View.GONE
            }
            btn_read_dosha_res.visibility = if (any_dosha == -1) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }
    }

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

    fun View.containersVisibilityState(){
        this.ContainerLayout_Res_Animal.visibility = if (state_op_close_res == 1) {
            View.VISIBLE
        } else {
            View.GONE
        }
        this.ContainerLayout_Res_Doshi.visibility = if (state_op_close_res == 2) {
            View.VISIBLE
        } else {
            View.GONE
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