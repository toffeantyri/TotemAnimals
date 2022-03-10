package com.totems.totemanimals.view.mainFragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.totems.totemanimals.R
import kotlinx.android.synthetic.main.fragment_fragment_info.view.*


class fragment_info : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(container?.context).inflate(R.layout.fragment_fragment_info,container,false)


        view.btn_my_inst.setOnClickListener {
            val br_intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/foxy_antoffy"))
            startActivity(br_intent)
        }

        view.tv_site_righter_text.setOnClickListener {
            val br_intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://o-sebe.com"))
            startActivity(br_intent)
        }



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MyLog", "onViewCreated")
    }

    companion object {
        @JvmStatic
        fun newInstance() = fragment_info()



    }
}

