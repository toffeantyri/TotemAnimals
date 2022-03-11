package com.totems.totemanimals.view.mainFragments

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.totems.totemanimals.view.mainAdapters.Animal
import com.totems.totemanimals.Animal_descpt_view
import com.totems.totemanimals.R
import com.totems.totemanimals.StartTest_activity
import com.totems.totemanimals.resoursesTests.list_resours.descriptIdList
import com.totems.totemanimals.resoursesTests.list_resours.imIdList
import com.totems.totemanimals.resoursesTests.list_resours.nameIdList
import com.totems.totemanimals.view.Animations
import kotlinx.android.synthetic.main.fragment_fragment_test_result.*
import kotlinx.android.synthetic.main.fragment_fragment_test_result.view.*

class fragment_testResult : Fragment() {

    lateinit var animat_var: Animations
    lateinit var handler: Handler
    lateinit var rect_r10_all : Drawable
    lateinit var rect_r10_up : Drawable



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view0 = LayoutInflater.from(container?.context).inflate(R.layout.fragment_fragment_test_result,container,false)
        val state_op_close_res = arguments?.getInt("state_open_close_res") ?: 0
        val first_name:Int = arguments?.getInt("first_name") ?: -1
        val first_volume:Int = arguments?.getInt("first_volume")?: -1
        val second_name:Int = arguments?.getInt("second_name")?: -1
        val second_volume:Int = arguments?.getInt("second_volume")?: -1
        val last_name:Int = arguments?.getInt("last_name")?: -1
        val all_volume:Int = arguments?.getInt("all_volume")?: -1

        rect_r10_all = resources.getDrawable(R.drawable.shape_rectangle_r10)
        rect_r10_up = resources.getDrawable(R.drawable.shape_rectangle_r10_up)


        view0.tv_no_results.visibility = if(first_name==-1)
                    {if(state_op_close_res==1) {View.VISIBLE}
                     else{View.GONE}        }
        else {View.GONE}



        animat_var = Animations()
        handler = Handler()


        viewBindResultFromBungle(view0,first_name,first_volume,second_name,second_volume,last_name,all_volume)
        view0.ContainerLayout_Res_Animal.visibility = if(state_op_close_res==1) {View.VISIBLE} else {View.GONE}

        if(state_op_close_res==1) {view0.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_less_black_32dp)}
        else {view0.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_more_black_32dp)}


        view0.btn_start_test.setOnClickListener {
            val intent = Intent(activity,
                StartTest_activity::class.java)
            intent.putExtra("new_test", "new_animaltotem_test")
            activity?.startActivityForResult(intent,100)
        }
        Log.d("MyLog", "OnCreateView Fragment_testResult " )


        view0.LinearLayout_result1.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n1)
        val first_animal = animal_construct(first_name)
            val intent = Intent(activity, Animal_descpt_view::class.java)
            intent.putExtra("description_result", first_animal)
            handler.postDelayed({startActivity(intent)},300)
        }
        view0.LinearLayout_result2.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n2)
        val second_animal = animal_construct(second_name)
            val intent = Intent(activity, Animal_descpt_view::class.java)
            intent.putExtra("description_result", second_animal)
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
            if(view0.ContainerLayout_Res_Animal.visibility == View.VISIBLE || view0.tv_no_results.visibility == View.VISIBLE){
                view0.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
                view0.ContainerLayout_Res_Animal.visibility = View.GONE
                view0.tv_no_results.visibility = View.GONE
                view0.im_arrow_down_an_result.background = rect_r10_all



            }
            else if (view0.ContainerLayout_Res_Animal.visibility == View.GONE || view0.tv_no_results.visibility == View.GONE) {
                view0.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_less_black_32dp)
                view0.ContainerLayout_Res_Animal.visibility = View.VISIBLE
                view0.im_arrow_down_an_result.background = rect_r10_up


                animat_var.down_result(view0.ContainerLayout_Res_Animal)

                if(first_name==-1) view0.tv_no_results.visibility = View.VISIBLE
            }
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

    fun animal_construct(number_animal_index: Int) : Animal {
        if(number_animal_index!=(-1)&&number_animal_index<= imIdList.size){
            val animalRes = Animal(
                imIdList[number_animal_index], nameIdList[number_animal_index],
                descriptIdList[number_animal_index]
            )
            return animalRes}
        else return Animal(
            0,
            "null_construct",
            "null_construct"
        )
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
            args.putInt("state_open_close_res",pref0[0]) // состояние теста - откр/закрыты подробнее в BaseActivity
            args.putInt("first_name", pref0[1])
            args.putInt("first_volume", pref0[2])
            args.putInt("second_name", pref0[3])
            args.putInt("second_volume", pref0[4])
            args.putInt("last_name", pref0[5])
            args.putInt("all_volume", pref0[6])
            fragment.arguments=args
            return fragment}
    }
}


