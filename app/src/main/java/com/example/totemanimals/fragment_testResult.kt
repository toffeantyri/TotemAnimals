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
        val i = arguments?.getString("pref0")
        view0.tv_pref_result.text=i.toString()

        view0.btn_start_test.setOnClickListener {
            val intent = Intent(activity,StartTest_activity::class.java)
            intent.putExtra("newtest", "newtest")
            activity?.startActivityForResult(intent,100)

        }

        Log.d("MyLog", "OnCreateView Fragment_testResult " +  i)
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
        fun newInstance(pref0: List<Any>) : fragment_testResult {
            val fragment = fragment_testResult()
            val args = Bundle()
            args.putString("pref0", pref0[0].toString())
            fragment.arguments=args
            return fragment}
    }

}



