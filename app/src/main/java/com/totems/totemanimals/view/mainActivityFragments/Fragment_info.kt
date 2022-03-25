package com.totems.totemanimals.view.mainActivityFragments

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


class Fragment_info : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(container?.context).inflate(R.layout.fragment_fragment_info,container,false)
        view.bindingButtons()





        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MyLog", "onViewCreated")
    }

    fun View.bindingButtons(){
        this.apply {
            btn_my_inst.setOnClickListener {
                val br_intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/foxy_antoffy"))
                startActivity(br_intent)
            }

            tv_site_righter_text.setOnClickListener {
                val br_intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://o-sebe.com"))
                startActivity(br_intent)
            }
            btn_estimate.setOnClickListener {
                val br_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.totems.totemanimals"))
                startActivity(br_intent)
            }

            btn_share_app.setOnClickListener {
                val link = getString(R.string.only_link_app)
                val text = getString(R.string.text_share_link_app)
                val intent = Intent()
                intent.setAction(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_TEXT, text + "\n" + link )
                intent.setType("text/plain")
                Log.d("MyLog", text + "\n" + link)
                startActivity(Intent.createChooser(intent, getString(R.string.share_totem)))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment_info()
    }



}

