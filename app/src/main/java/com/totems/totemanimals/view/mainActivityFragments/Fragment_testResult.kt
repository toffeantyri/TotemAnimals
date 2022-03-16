package com.totems.totemanimals.view.mainActivityFragments

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.totems.totemanimals.ActivityDescptView
import com.totems.totemanimals.R
import com.totems.totemanimals.StartTest_activity
import com.totems.totemanimals.resoursesTests.list_resours.descriptIdList
import com.totems.totemanimals.resoursesTests.list_resours.imIdList
import com.totems.totemanimals.resoursesTests.list_resours.nameIdList
import com.totems.totemanimals.view.mainAdapters.MyPieEntry
import com.totems.totemanimals.view.mainAdapters.PieValueSelect
import com.totems.totemanimals.view.mainAdapters.ShablonAnimalDataClass

import com.totems.totemanimals.view.mainQuestion.Animations
import com.yandex.metrica.impl.ob.F
import kotlinx.android.synthetic.main.fragment_fragment_test_result.*
import kotlinx.android.synthetic.main.fragment_fragment_test_result.view.*

class fragment_testResult : Fragment() {

    lateinit var animat_var: Animations
    lateinit var handler: Handler
    lateinit var rect_r10_all: Drawable
    lateinit var rect_r10_up: Drawable

    lateinit var myValueListener :PieValueSelect
    lateinit var myChartListener : PieValueSelect.PieChartTouchListener

    lateinit var listResultDoshi : ArrayList<PieEntry>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view0: View =
            LayoutInflater.from(container?.context).inflate(R.layout.fragment_fragment_test_result, container, false)
        var state_op_close_res = arguments?.getInt("state_open_close_res") ?: 0
        val first_name: Int = arguments?.getInt("first_name") ?: -1
        val first_volume: Int = arguments?.getInt("first_volume") ?: -1
        val second_name: Int = arguments?.getInt("second_name") ?: -1
        val second_volume: Int = arguments?.getInt("second_volume") ?: -1
        val last_name: Int = arguments?.getInt("last_name") ?: -1
        val all_volume: Int = arguments?.getInt("all_volume") ?: -1

        //TODO defaul value на 0
        val vataResult: Float = arguments?.getFloat("vata_result") ?: 10f
        val pittaResult: Float = arguments?.getFloat("pitta_result") ?: 20f
        val kaphaResult: Float = arguments?.getFloat("kapha_result") ?: 30f
        listResultDoshi = arrayListOf(PieEntry(10f,"Вата"),PieEntry(20f,"Питта"),PieEntry(15f,"Капха"))
        myValueListener = PieValueSelect(listResultDoshi)
        myChartListener = myValueListener.PieChartTouchListener()

        animat_var = Animations()
        handler = Handler()
        rect_r10_all = resources.getDrawable(R.drawable.shape_rectangle_r10)
        rect_r10_up = resources.getDrawable(R.drawable.shape_rectangle_r10_up)

        //TODO TEST
        state_op_close_res = 2

        view0.tv_no_results.visibility = if (first_name == -1) {
            if (state_op_close_res == 1) {
                View.VISIBLE
            } else {
                View.GONE
            }
        } else {
            View.GONE
        }

        //TODO сдесь first_name заменить на приходящий результат доша теста (если его нет то показывает нет результата)
        view0.tv_no_results_dosha.visibility = if (first_name == -1) {
            if (state_op_close_res == 2) {
                View.VISIBLE
            } else {
                View.GONE
            }
        } else {
            View.GONE
        }


        //TODO Стрелка будет работать нормально когда Видимость контейнера будет соответсововать дейтсвительности сейчас он висибл
        if (state_op_close_res == 1) {
            view0.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_less_black_32dp)
            view0.im_arrow_down_dosh_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
        } else if (state_op_close_res == 2) {
            view0.im_arrow_down_dosh_result.setImageResource(R.drawable.ic_expand_less_black_32dp)
            view0.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
        } else {
            view0.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
            view0.im_arrow_down_dosh_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
        }

        viewBindResultFromBungle(view0, first_name, first_volume, second_name, second_volume, last_name, all_volume)



        view0.ContainerLayout_Res_Animal.visibility = if (state_op_close_res == 1) {
            View.VISIBLE
        } else { View.GONE        }

        view0.ContainerLayout_Res_Doshi.visibility = if (state_op_close_res == 2) {
            View.VISIBLE
        } else { View.GONE   }




        view0.btn_start_test.setOnClickListener {
            val intent = Intent(
                activity,
                StartTest_activity::class.java
            )
            intent.putExtra("new_test", "new_animaltotem_test")
            activity?.startActivityForResult(intent, 100)
        }


        view0.LinearLayout_result1.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n1)
            val first_animal: ShablonAnimalDataClass = animal_construct(first_name)
            val intent = Intent(activity, ActivityDescptView::class.java)
            intent.putExtra(first_animal.INTENT_KEY_RESULT, first_animal)
            handler.postDelayed({ startActivity(intent) }, 300)
        }
        view0.LinearLayout_result2.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n2)
            val second_animal = animal_construct(second_name)
            val intent = Intent(activity, ActivityDescptView::class.java)
            intent.putExtra(second_animal.INTENT_KEY_RESULT, second_animal)
            handler.postDelayed({ startActivity(intent) }, 300)
        }
        view0.LinearLayout_result3.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n3)
            val last_animal = animal_construct(last_name)
            val intent = Intent(activity, ActivityDescptView::class.java)
            intent.putExtra(last_animal.INTENT_KEY_RESULT, last_animal)
            handler.postDelayed({ startActivity(intent) }, 300)
        }

        view0.im_arrow_down_an_result.setOnClickListener {
            val context = context ?: requireActivity()
            if (view0.ContainerLayout_Res_Animal.visibility == View.VISIBLE || view0.tv_no_results.visibility == View.VISIBLE) {
                view0.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
                view0.ContainerLayout_Res_Animal.visibility = View.GONE
                view0.tv_no_results.visibility = View.GONE
                view0.im_arrow_down_an_result.background = rect_r10_all
            } else if (view0.ContainerLayout_Res_Animal.visibility == View.GONE || view0.tv_no_results.visibility == View.GONE) {
                view0.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_less_black_32dp)
                view0.ContainerLayout_Res_Animal.visibility = View.VISIBLE
                view0.im_arrow_down_an_result.background = rect_r10_up
                animat_var.down_result(view0.ContainerLayout_Res_Animal)
                if (first_name == -1) view0.tv_no_results.visibility = View.VISIBLE
            }


        }
        view0.im_arrow_down_dosh_result.setOnClickListener {
            if (view0.ContainerLayout_Res_Doshi.visibility == View.VISIBLE || view0.tv_no_results_dosha.visibility == View.VISIBLE) {
                view0.im_arrow_down_dosh_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
                view0.ContainerLayout_Res_Doshi.visibility = View.GONE
                view0.tv_no_results_dosha.visibility = View.GONE
                view0.im_arrow_down_dosh_result.background = rect_r10_all
            } else if (view0.ContainerLayout_Res_Doshi.visibility == View.GONE || view0.tv_no_results_dosha.visibility == View.GONE) {
                view0.im_arrow_down_dosh_result.setImageResource(R.drawable.ic_expand_less_black_32dp)
                view0.ContainerLayout_Res_Doshi.visibility = View.VISIBLE
                view0.im_arrow_down_dosh_result.background = rect_r10_up
                animat_var.down_result(view0.ContainerLayout_Res_Doshi)
                if (first_name == -1) view0.tv_no_results_dosha.visibility = View.VISIBLE
            }
        }

        Log.d("MyLog", "OnCreateView Fragment_testResult ")
        return view0

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chart = view.findViewById<PieChart>(R.id.dosha_result_diagram)
        viewBindResultDoshaFromBungle(chart)
        chart.onChartGestureListener = myChartListener
        chart.setOnChartValueSelectedListener(myValueListener)
        val werwe = myValueListener.enteryValue

    }



    fun animal_construct(number_animal_index: Int): ShablonAnimalDataClass {
        if (number_animal_index != (-1) && number_animal_index <= imIdList.size) {
            val animalRes = ShablonAnimalDataClass(
                imIdList[number_animal_index], nameIdList[number_animal_index],
                descriptIdList[number_animal_index]
            )
            return animalRes
        } else return ShablonAnimalDataClass(
            0,
            "null_construct",
            "null_construct"
        )
    }


    fun viewBindResultFromBungle(view: View, f_n: Int, f_v: Int, s_n: Int, s_v: Int, l_n: Int, a_v: Int) {
        val f_vol_meas = (a_v / imIdList.size * f_v).toString()
        val s_vol_meas = (a_v / imIdList.size * s_v).toString()
        val f_vol: String = f_vol_meas + "/" + a_v
        val s_vol: String = s_vol_meas + "/" + a_v

        if (f_n >= 0) {
            view.im_testresult_n1.setImageResource(imIdList[f_n])
            view.tv_testresult_title_n1.text = nameIdList[f_n]
            view.tv_testresult_perc_n1.text = f_vol
            view.LinearLayout_result1.visibility = View.VISIBLE
        } else view.LinearLayout_result1.visibility = View.GONE

        if (s_n >= 0) {
            view.im_testresult_n2.setImageResource(imIdList[s_n])
            view.tv_testresult_title_n2.text = nameIdList[s_n]
            view.tv_testresult_perc_n2.text = s_vol
            view.LinearLayout_result2.visibility = View.VISIBLE
        } else view.LinearLayout_result2.visibility = View.GONE

        if (l_n >= 0) {
            view.im_testresult_n3.setImageResource(imIdList[l_n])
            view.tv_testresult_title_n3.text = nameIdList[l_n]
            view.LinearLayout_result3.visibility = View.VISIBLE
        } else view.LinearLayout_result3.visibility = View.GONE

    }


    fun viewBindResultDoshaFromBungle(pieChart: PieChart){
        val pieDataSet = PieDataSet(listResultDoshi,"")
        val colors = mutableListOf<Int>(
            resources.getColor(R.color.dosha_vata_blue),
            resources.getColor(R.color.dosha_pitta_red),
            resources.getColor(R.color.dosha_kapha_green))

        val mypieChart : PieChart = pieChart
            mypieChart.apply {
            setUsePercentValues(true)
                description.isEnabled = false
            val legend : Legend = pieChart.legend
                legend.textSize = 14f
                legend.setDrawInside(false)
                legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
                legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
            setExtraOffsets(5F,10F,5F,5F)
            centerText = getString(R.string.name_diagramm)
            isClickable = true
            setCenterTextSize(16F)
            dragDecelerationFrictionCoef = 0.9f
            transparentCircleRadius = 100f
            setHoleColor(resources.getColor(R.color.hole_white_alpha))
        }
        pieDataSet.apply {
            sliceSpace = 3f
            selectionShift = 5f
            setColors(colors)
        }
        val pieData = PieData(pieDataSet)
        pieData.apply {
            setValueTextSize(16f)
            setValueTextColor(Color.BLACK)
        }
        mypieChart.data = pieData




    }

    companion object {
        @JvmStatic
        fun newInstance(pref0: Array<Int>): fragment_testResult {
            val fragment = fragment_testResult()
            val args = Bundle()
            args.putInt("state_open_close_res", pref0[0]) // состояние теста - откр/закрыты подробнее в BaseActivity
            args.putInt("first_name", pref0[1])
            args.putInt("first_volume", pref0[2])
            args.putInt("second_name", pref0[3])
            args.putInt("second_volume", pref0[4])
            args.putInt("last_name", pref0[5])
            args.putInt("all_volume", pref0[6])
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Log.d("MyLog","fragm testresult onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        // Log.d("MyLog","fragm testresult onDetach")
    }
}



