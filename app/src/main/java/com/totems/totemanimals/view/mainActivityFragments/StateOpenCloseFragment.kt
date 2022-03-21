package com.totems.totemanimals.view.mainActivityFragments

import android.os.Handler

import android.view.View
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import com.totems.totemanimals.R
import kotlinx.android.synthetic.main.fragment_fragment_test_result.view.*


open class StateOpenCloseFragment : Fragment() {

    open var state_op_close_res: Int = 0
    open var handler : Handler = Handler()


    fun View.tvNoResultsVisibility(first_name_animal: Int, any_dosha: Int) {
        this.tv_no_results.visibility = if (first_name_animal == -1) {
            if (state_op_close_res == 1) {
                View.VISIBLE
            } else {
                View.GONE
            }
        } else {
            View.GONE
        }

        this.tv_no_results_dosha.visibility = if (any_dosha == -1) {
            if (state_op_close_res == 2) {
                View.VISIBLE
            } else {
                View.GONE
            }
        } else {
            View.GONE
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

    fun ScrollView.scrollToCenterView(targetView : View){
        handler.postDelayed({this.smoothScrollBy(0, targetView.top+250)},10)
    }


}