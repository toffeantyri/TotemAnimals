package com.example.totemanimals

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.preference.PreferenceManager
import com.example.totemanimals.list_resours.descriptIdList
import com.example.totemanimals.list_resours.imIdList
import com.example.totemanimals.list_resours.nameIdList
import kotlinx.android.synthetic.main.fragment_fragment_test_result.*
import kotlinx.android.synthetic.main.fragment_fragment_test_result.view.*

class fragment_testResult : Fragment() {

    lateinit var animat_var: Animations
    lateinit var handler: Handler



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view0 = LayoutInflater.from(container?.context).inflate(R.layout.fragment_fragment_test_result,container,false)
        val first_name:Int = arguments?.getInt("first_name") ?: -1
        val first_volume:Int = arguments?.getInt("first_volume")?: -1
        val second_name:Int = arguments?.getInt("second_name")?: -1
        val second_volume:Int = arguments?.getInt("second_volume")?: -1
        val last_name:Int = arguments?.getInt("last_name")?: -1
        val all_volume:Int = arguments?.getInt("all_volume")?: -1

        animat_var = Animations()
        handler = Handler()


        viewBindResultFromBungle(view0,first_name,first_volume,second_name,second_volume,last_name,all_volume)

        view0.btn_start_test.setOnClickListener {
            val intent = Intent(activity,StartTest_activity::class.java)
            intent.putExtra("new_test", "new_animaltotem_test")
            activity?.startActivityForResult(intent,100)
        }
        Log.d("MyLog", "OnCreateView Fragment_testResult " )


        view0.LinearLayout_result1.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n1)
        val first_animal = animal_construct(first_name)
            val intent = Intent(activity, Animal_descpt_view::class.java)
            intent.putExtra("description_search", first_animal)
            handler.postDelayed({startActivity(intent)},300)
        }
        view0.LinearLayout_result2.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n2)
        val second_animal = animal_construct(second_name)
            val intent = Intent(activity, Animal_descpt_view::class.java)
            intent.putExtra("description_search", second_animal)
            handler.postDelayed({startActivity(intent)},300)
        }
        view0.LinearLayout_result3.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n3)
        val last_animal = animal_construct(last_name)
            val intent = Intent(activity, Animal_descpt_view::class.java)
            intent.putExtra("description_search", last_animal)
            handler.postDelayed({startActivity(intent)},300)
        }
        view0.im_arrow_down_an_result.setOnClickListener{
            val context = context ?: requireActivity()
            TransitionManager.beginDelayedTransition(CardView(context),AutoTransition())
            if(view0.ContainerLayout_Res_Animal.visibility == View.VISIBLE) {view0.ContainerLayout_Res_Animal.visibility = View.GONE} else {view0.ContainerLayout_Res_Animal.visibility = View.VISIBLE}
        }

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

    fun animal_construct(number_animal_index: Int) :Animal   {
        if(number_animal_index!=(-1)&&number_animal_index<= imIdList.size){
            val animalRes = Animal(
                imIdList[number_animal_index], nameIdList[number_animal_index],
                descriptIdList[number_animal_index])
            return animalRes}
        else return Animal(0,"null_construct", "null_construct")
    }


    fun viewBindResultFromBungle(view: View,f_n:Int,f_v:Int,s_n:Int,s_v:Int,l_n:Int,a_v:Int) {
        val f_vol_meas = (a_v/imIdList.size*f_v).toString()
        val s_vol_meas = (a_v/imIdList.size*s_v).toString()
        val f_vol: String = f_vol_meas + "/" + a_v
        val s_vol: String = s_vol_meas + "/" + a_v

        if (f_n>=0) {
            view.im_testresult_n1.setImageResource(imIdList[f_n])
            view.tv_testresult_title_n1.text = nameIdList[f_n]
            view.tv_testresult_perc_n1.text = f_vol
            view.LinearLayout_result1.visibility = View.VISIBLE        }
        else view.LinearLayout_result1.visibility = View.GONE

        if (s_n>=0) {
            view.im_testresult_n2.setImageResource(imIdList[s_n])
            view.tv_testresult_title_n2.text = nameIdList[s_n]
            view.tv_testresult_perc_n2.text = s_vol
            view.LinearLayout_result2.visibility = View.VISIBLE        }
        else view.LinearLayout_result2.visibility = View.GONE

        if (l_n>=0) {
            view.im_testresult_n3.setImageResource(imIdList[l_n])
            view.tv_testresult_title_n3.text = nameIdList[l_n]
            view.LinearLayout_result3.visibility = View.VISIBLE            }
        else view.LinearLayout_result3.visibility = View.GONE

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
            args.putInt("all_volume", pref0[5])
            fragment.arguments=args
            return fragment}
    }
}



