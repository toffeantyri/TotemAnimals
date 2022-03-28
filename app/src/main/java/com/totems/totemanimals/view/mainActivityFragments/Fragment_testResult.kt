package com.totems.totemanimals.view.mainActivityFragments

import android.annotation.SuppressLint
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
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.totems.totemanimals.ActivityDescptView
import com.totems.totemanimals.R
import com.totems.totemanimals.StartTest_activity
import com.totems.totemanimals.resoursesTests.List_Resours_Doshi
import com.totems.totemanimals.resoursesTests.List_resours_an_totem
import com.totems.totemanimals.view.mainAdapters.doshi_adapters.DiagramMarkerView
import com.totems.totemanimals.view.mainAdapters.doshi_adapters.PieValueSelect
import com.totems.totemanimals.view.mainAdapters.doshi_adapters.ShablonDoshaDataClass
import com.totems.totemanimals.view.mainAdapters.totemanimaladapters.ShablonAnimalDataClass

import com.totems.totemanimals.view.mainQuestion.Animations
import com.totems.totemanimals.viewModel.DataModelTestResult
import kotlinx.android.synthetic.main.fragment_fragment_test_result.*
import kotlinx.android.synthetic.main.fragment_fragment_test_result.view.*
import java.lang.StringBuilder

class fragment_testResult : StateOpenCloseFragment() {

    companion object {
        @JvmStatic
        fun newInstance(): fragment_testResult {
            val fragment = fragment_testResult()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    val dataModel : DataModelTestResult by activityViewModels()
    lateinit var animat_var: Animations
    lateinit var rect_r10_all: Drawable
    lateinit var rect_r10_up: Drawable

    override var state_op_close_res: Int = super.state_op_close_res
    var first_name: Int = -1
    var first_volume: Int = -1
    var second_name: Int = -1
    var second_volume: Int = -1
    var last_name: Int = -1
    var all_volume: Int = -1

    lateinit var myValueListener: PieValueSelect
    lateinit var myChartListener: PieValueSelect.PieChartTouchListener
    lateinit var myMarkerView: MarkerView

    var vataResult: Int = -1
    var pittaResult: Int = -1
    var kaphaResult: Int = -1
    lateinit var listResultDoshi: ArrayList<PieEntry>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view0: View =
            LayoutInflater.from(container?.context).inflate(R.layout.fragment_fragment_test_result, container, false)
        animat_var = Animations()
        handler = Handler()
        rect_r10_all = resources.getDrawable(R.drawable.shape_rectangle_r10)
        rect_r10_up = resources.getDrawable(R.drawable.shape_rectangle_r10_up)

        dataModel.stateOpenTestAnimal.observe(activity as LifecycleOwner, {
            state_op_close_res = it
        })

        dataModel.resultTotemTest.observe(activity as LifecycleOwner, {
            first_name = it[0]
            first_volume = it[1]
            second_name = it[2]
            second_volume = it[3]
            last_name = it[4]
            all_volume = it[5]
        })

        dataModel.resultDoshaTest.observe(activity as LifecycleOwner, {
            vataResult = it[0]
            pittaResult = it[1]
            kaphaResult = it[2]
        })

        Log.d("MyLog", "OnCreateView testResult ")
        return view0
    }

    override fun onResume() {
        super.onResume()
        //все проверки состояний во фрагменте. только в onResume!
        Log.d("MyLog", "TestResultFr  onResume: $vataResult , $pittaResult, $kaphaResult")
        Log.d("MyLog", "TestResultFr onResume Doshas: ${dataModel.resultDoshaTest.value.toString()}")
        Log.d("MyLog", "TestResultFr onResume Animals: ${dataModel.resultTotemTest.value.toString()}")

        view?.arrowUpDownStateView()
        view?.containersVisibilityState()
        view?.tvNoResultsVisibility(first_name, vataResult)

        view?.viewBindResultFromBungle(first_name, first_volume, second_name, second_volume, last_name, all_volume)

        listResultDoshi = arrayListOf(
            PieEntry(vataResult.toFloat(), getString(R.string.dosha_title_vata)),
            PieEntry(pittaResult.toFloat(), getString(R.string.dosha_title_pitta)),
            PieEntry(kaphaResult.toFloat(), getString(R.string.dosha_title_kapha))
        )

        view?.bindAllButtonStartTest()
        view?.bindResultReadButtons()

        myValueListener = PieValueSelect(listResultDoshi)
        myChartListener = myValueListener.PieChartTouchListener()
        myMarkerView = DiagramMarkerView(context!!, R.layout.marker_view_diagram)
        dosha_result_diagram.onChartGestureListener = myChartListener
        dosha_result_diagram.setOnChartValueSelectedListener(myValueListener)

        view?.viewBindResultDoshaFromBungle(
            dosha_result_diagram,
            listResultDoshi[0].y.toInt(),
            listResultDoshi[1].y.toInt(),
            listResultDoshi[2].y.toInt()
        )

        if (state_op_close_res == 1) {
            view?.testResScrollView?.scrollToCenterView(ContainerLayout_Res_Animal, 0)
        }
        if (state_op_close_res == 2) {
            view?.testResScrollView?.scrollToCenterView(ContainerLayout_Res_Doshi, 300)
        }
    }

    fun animal_construct(number_animal_index: Int): ShablonAnimalDataClass {
        if (number_animal_index != (-1) && number_animal_index <= List_resours_an_totem.imIdList.size) {
            val animalRes = ShablonAnimalDataClass(
                List_resours_an_totem.imIdList[number_animal_index],
                List_resours_an_totem.nameIdList[number_animal_index],
                List_resours_an_totem.descriptIdList[number_animal_index]
            )
            return animalRes
        } else return ShablonAnimalDataClass(
            0,
            "null_construct",
            "null_construct"
        )
    }

    fun doshaDescrClassConstructor(vataRes: Int, pittaRes: Int, kaphaRes: Int): ShablonDoshaDataClass {
        val image: Int = List_Resours_Doshi.imIdList[0]
        //title appender
        val title = StringBuilder()
        if (vataRes < List_Resours_Doshi.BALANCE_LEVEL_MIN || vataRes > List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            title.append(List_Resours_Doshi.nameIdList[0])
        }
        if (pittaRes < List_Resours_Doshi.BALANCE_LEVEL_MIN || pittaRes > List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            title.append(List_Resours_Doshi.nameIdList[1])
        }
        if (kaphaRes < List_Resours_Doshi.BALANCE_LEVEL_MIN || kaphaRes > List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            title.append(List_Resours_Doshi.nameIdList[2])
        }
        if (vataRes.toFloat() in List_Resours_Doshi.BALANCE_LEVEL_MIN..List_Resours_Doshi.BALANCE_LEVEL_MAX && pittaRes.toFloat() in List_Resours_Doshi.BALANCE_LEVEL_MIN..List_Resours_Doshi.BALANCE_LEVEL_MAX && kaphaRes.toFloat() in List_Resours_Doshi.BALANCE_LEVEL_MIN..List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            title.append(List_Resours_Doshi.nameIdList[3])
        }
        //description appender addList
        // 0-low 1-high 2-bal vata || 3-low 4-high 5-bal pitta|| 6-low 7-high 8-bal kapha
        val desc = StringBuilder()
        if (vataRes.toFloat() in List_Resours_Doshi.BALANCE_LEVEL_MIN..List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            desc.append(List_Resours_Doshi.addDescriptionList[2])
        }
        if (pittaRes.toFloat() in List_Resours_Doshi.BALANCE_LEVEL_MIN..List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            desc.append(List_Resours_Doshi.addDescriptionList[5])
        }
        if (kaphaRes.toFloat() in List_Resours_Doshi.BALANCE_LEVEL_MIN..List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            desc.append(List_Resours_Doshi.addDescriptionList[8])
        }
        if (vataRes < List_Resours_Doshi.BALANCE_LEVEL_MIN) {
            desc.append(List_Resours_Doshi.addDescriptionList[0])
        }
        if (vataRes > List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            desc.append(List_Resours_Doshi.addDescriptionList[1])
        }
        if (pittaRes < List_Resours_Doshi.BALANCE_LEVEL_MIN) {
            desc.append(List_Resours_Doshi.addDescriptionList[3])
        }
        if (pittaRes > List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            desc.append(List_Resours_Doshi.addDescriptionList[4])
        }
        if (kaphaRes < List_Resours_Doshi.BALANCE_LEVEL_MIN) {
            desc.append(List_Resours_Doshi.addDescriptionList[6])
        }
        if (kaphaRes > List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            desc.append(List_Resours_Doshi.addDescriptionList[7])
        }

        //description appender desc List
        if (vataRes < List_Resours_Doshi.BALANCE_LEVEL_MIN || vataRes > List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            desc.append(List_Resours_Doshi.descriptIdList[0])
        }
        if (pittaRes < List_Resours_Doshi.BALANCE_LEVEL_MIN || pittaRes > List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            desc.append(List_Resours_Doshi.descriptIdList[1])
        }
        if (kaphaRes < List_Resours_Doshi.BALANCE_LEVEL_MIN || kaphaRes > List_Resours_Doshi.BALANCE_LEVEL_MAX) {
            desc.append(List_Resours_Doshi.descriptIdList[2])
        }

        return ShablonDoshaDataClass(image, title.toString(), desc.toString())
    }

    fun View.viewBindResultFromBungle(f_n: Int, f_v: Int, s_n: Int, s_v: Int, l_n: Int, a_v: Int) {
        val f_vol_meas = ((f_v*100/28).toInt()).toString()
        val s_vol_meas = ((s_v*100/28).toInt()).toString()
        val f_vol: String = f_vol_meas + " %"
        val s_vol: String = s_vol_meas + " %"

        if (f_n >= 0) {
            this.im_testresult_n1.setImageResource(List_resours_an_totem.imIdList[f_n])
            this.tv_testresult_title_n1.text = List_resours_an_totem.nameIdList[f_n]
            this.tv_testresult_perc_n1.text = f_vol
            this.LinearLayout_result1.visibility = View.VISIBLE
        } else this.LinearLayout_result1.visibility = View.GONE

        if (s_n >= 0) {
            this.im_testresult_n2.setImageResource(List_resours_an_totem.imIdList[s_n])
            this.tv_testresult_title_n2.text = List_resours_an_totem.nameIdList[s_n]
            this.tv_testresult_perc_n2.text = s_vol
            this.LinearLayout_result2.visibility = View.VISIBLE
        } else this.LinearLayout_result2.visibility = View.GONE

        if (l_n >= 0) {
            this.im_testresult_n3.setImageResource(List_resours_an_totem.imIdList[l_n])
            this.tv_testresult_title_n3.text = List_resours_an_totem.nameIdList[l_n]
            this.LinearLayout_result3.visibility = View.VISIBLE
        } else this.LinearLayout_result3.visibility = View.GONE

    }

    fun View.viewBindResultDoshaFromBungle(pieChart: PieChart, vataRes: Int, pittaRes: Int, kaphaRes: Int) {

        if (vataRes >= 0 && pittaRes >= 0 && kaphaRes >= 0) {
            this.dosha_result_diagram.visibility = View.VISIBLE
        } else this.dosha_result_diagram.visibility = View.GONE

        val pieDataSet = PieDataSet(listResultDoshi, "")
        val colors = mutableListOf<Int>(
            resources.getColor(R.color.dosha_vata_blue),
            resources.getColor(R.color.dosha_pitta_red),
            resources.getColor(R.color.dosha_kapha_green)
        )

        val mypieChart: PieChart = pieChart
        mypieChart.apply {
            setUsePercentValues(true)
            description.isEnabled = false
            val legend: Legend = pieChart.legend
            legend.textSize = 14f
            legend.setDrawInside(false)
            legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
            legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
            setExtraOffsets(5F, 10F, 5F, 5F)
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
        mypieChart.setDrawMarkers(true)
        mypieChart.markerView = myMarkerView
        mypieChart.data = pieData
    }

    fun View.bindResultReadButtons() {
        this.LinearLayout_result1.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n1)
            val first_animal: ShablonAnimalDataClass = animal_construct(first_name)
            val intent = Intent(activity, ActivityDescptView::class.java)
            intent.putExtra(first_animal.INTENT_KEY_RESULT, first_animal)
            handler.postDelayed({ startActivity(intent) }, 300)
        }
        this.LinearLayout_result2.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n2)
            val second_animal = animal_construct(second_name)
            val intent = Intent(activity, ActivityDescptView::class.java)
            intent.putExtra(second_animal.INTENT_KEY_RESULT, second_animal)
            handler.postDelayed({ startActivity(intent) }, 300)
        }
        this.LinearLayout_result3.setOnClickListener {
            animat_var.anim_Testresult(im_testresult_n3)
            val last_animal = animal_construct(last_name)
            val intent = Intent(activity, ActivityDescptView::class.java)
            intent.putExtra(last_animal.INTENT_KEY_RESULT, last_animal)
            handler.postDelayed({ startActivity(intent) }, 300)
        }

        this.btn_read_dosha_res.setOnClickListener {
            val resultConstruct = doshaDescrClassConstructor(vataResult, pittaResult, kaphaResult)
            val intent = Intent(activity, ActivityDescptView::class.java)
            intent.putExtra(resultConstruct.INTENT_KEY_RESULT, resultConstruct)
            startActivity(intent)
        }

        this.im_arrow_down_an_result.setOnClickListener {
            dataModel.stateOpenTestAnimal.value = 0
            if (this.ContainerLayout_Res_Animal.visibility == View.VISIBLE) {
                this.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
                this.ContainerLayout_Res_Animal.visibility = View.GONE
                this.im_arrow_down_an_result.background = rect_r10_all
            } else if (this.ContainerLayout_Res_Animal.visibility == View.GONE) {
                this.im_arrow_down_an_result.setImageResource(R.drawable.ic_expand_less_black_32dp)
                this.ContainerLayout_Res_Animal.visibility = View.VISIBLE
                this.im_arrow_down_an_result.background = rect_r10_up
                animat_var.down_result(this.ContainerLayout_Res_Animal)
            }
            this.tv_no_results.visibility = if (first_name == -1) View.VISIBLE else View.GONE
            if (first_name != -1) {
                this.testResScrollView.scrollToCenterView(ContainerLayout_Res_Animal, 0)
            }

        }
        this.im_arrow_down_dosh_result.setOnClickListener {
            dataModel.stateOpenTestAnimal.value = 0
            if (this.ContainerLayout_Res_Doshi.visibility == View.VISIBLE) {
                this.im_arrow_down_dosh_result.setImageResource(R.drawable.ic_expand_more_black_32dp)
                this.ContainerLayout_Res_Doshi.visibility = View.GONE
                this.im_arrow_down_dosh_result.background = rect_r10_all
            } else if (this.ContainerLayout_Res_Doshi.visibility == View.GONE) {
                this.im_arrow_down_dosh_result.setImageResource(R.drawable.ic_expand_less_black_32dp)
                this.ContainerLayout_Res_Doshi.visibility = View.VISIBLE
                this.im_arrow_down_dosh_result.background = rect_r10_up
                animat_var.down_result(this.ContainerLayout_Res_Doshi)

            }
            this.tv_no_results_dosha.visibility = if (vataResult == -1) View.VISIBLE else View.GONE
            if (vataResult != -1) {
                this.testResScrollView.scrollToCenterView(ContainerLayout_Res_Doshi, 300)
            }
        }
    }


}



