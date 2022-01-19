package com.example.totemanimals

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.preference.PreferenceManager
import com.example.totemanimals.list_resours.imIdList
import kotlinx.android.synthetic.main.fragment_fragment_test_result.*
import kotlinx.android.synthetic.main.fragment_fragment_test_result.view.*

class fragment_testResult : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view0 = LayoutInflater.from(container?.context).inflate(R.layout.fragment_fragment_test_result,container,false)
        val first_name = arguments?.getInt("first_name") ?: -1
        val first_volume = arguments?.getInt("first_volume")?: -1
        val second_name = arguments?.getInt("second_name")?: -1
        val second_volume = arguments?.getInt("second_volume")?: -1
        val last_name = arguments?.getInt("last_name")?: -1
        val last_volume = arguments?.getInt("last_volume")?: -1
        view0.tv_pref_result.text=first_name.toString()
        Log.d("MyLog", "$first_name $first_volume $second_name $second_volume $last_name $last_volume")

        resetViewFragmentTestResult(view0)
        viewBindResultOneFromBungle(view0,first_name,first_volume,second_name,second_volume,last_name,last_volume)


        view0.btn_start_test.setOnClickListener {
            val intent = Intent(activity,StartTest_activity::class.java)
            intent.putExtra("newtest", "new_animaltotem_test")
            activity?.startActivityForResult(intent,100)
        }
        Log.d("MyLog", "OnCreateView Fragment_testResult " )
        return view0

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
   // Log.d("MyLog","fragm testresult onAttach")
    }

    override fun onDetach() {
        super.onDetach()
       // Log.d("MyLog","fragm testresult onDetach")
    }


    companion object {
        @JvmStatic
        fun newInstance(pref0: Array<Int>) : fragment_testResult {
            val fragment = fragment_testResult()
            val args = Bundle()
            args.putInt("first_name", pref0[0])
            args.putInt("first_volume", pref0[1])
            args.putInt("second_name", pref0[2])
            args.putInt("second_volume", pref0[3])
            args.putInt("last_name", pref0[4])
            args.putInt("last_volume", pref0[5])
            fragment.arguments=args
            return fragment}
    }
    fun resetViewFragmentTestResult(view:View) {
        view.LinearLayout_result1.visibility=View.GONE
        view.LinearLayout_result2.visibility=View.GONE
        view.LinearLayout_result3.visibility=View.GONE
    }
    fun viewBindResultOneFromBungle(view: View,f_n:Int,f_v:Int,s_n:Int,s_v:Int,l_n:Int,l_v:Int) {


    }

}



