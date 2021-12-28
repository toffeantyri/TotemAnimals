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
import kotlinx.android.synthetic.main.fragment_fragment_test_result.*

class fragment_testResult : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view0 = LayoutInflater.from(container?.context).inflate(R.layout.fragment_fragment_test_result,container,false)
        return view0
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MyLog","onViewCreated fragment_testResult")
    }


    companion object {
        @JvmStatic
        fun newInstance() = fragment_testResult()

    }


}



