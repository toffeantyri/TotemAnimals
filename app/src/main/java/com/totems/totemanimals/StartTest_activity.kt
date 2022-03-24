package com.totems.totemanimals

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.preference.PreferenceManager
import com.totems.totemanimals.resoursesTests.List_Resours_Doshi
import com.totems.totemanimals.resoursesTests.List_resours_an_totem
import com.totems.totemanimals.resoursesTests.questionListDoshi
import com.totems.totemanimals.resoursesTests.questionListsTotemAnimal
import com.totems.totemanimals.view.mainQuestion.Animations
import com.totems.totemanimals.view.mainQuestion.questionsBindShablon
import com.totems.totemanimals.view.mainQuestion.resultBindShablon
import com.totems.totemanimals.viewModel.DataModelTestResult
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.common.MobileAds
import com.yandex.mobile.ads.interstitial.InterstitialAd
import com.yandex.mobile.ads.rewarded.Reward
import com.yandex.mobile.ads.rewarded.RewardedAd
import com.yandex.mobile.ads.rewarded.RewardedAdEventListener
import kotlinx.android.synthetic.main.activity_start_test_activity.*
import kotlinx.android.synthetic.main.activity_start_test_activity.view.*

class StartTest_activity : BaseActivity_ApComAct() {

    //lateinit var yandexInterstitialAd: InterstitialAd
    lateinit var yandexRewardAd: RewardedAd

    //для анимации и работы теста
    lateinit var test_res_list : Array<Int>
    lateinit var animat_var: Animations
    lateinit var handler: Handler
    lateinit var r: Runnable

    var index = 0 // индекс номер вопроса
    var n_q_index = 0// индекс номера количества ответов

    //для контента теста
    lateinit var quests: Array<String>
    lateinit var minimum_answ: Array<Int>
    lateinit var numbers_buttons: Array<Int>
    lateinit var lists_result_add: Array<Array<Array<Int>>>
    lateinit var name_button_list: Array<Array<String>>
    private var nums_max_quests = 0
    var im_background = -1

    //для контента количества результатов (Лист животных например)
    lateinit var list_results_counts: Array<Int>
    lateinit var btn: View
    var what_the_test: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_test_activity)
        Log.d("MyLog", "OnCreate StartTest_activity")
        what_the_test = intent.getStringExtra("new_test") ?: ""
        checkBind_WhatTheTest(what_the_test)
        test_res_list = Array<Int>(list_results_counts.count(), { 0 })


        //создаем массив наполненый колчеством 0 равный размеру вариантов результата теста(количество животных)
        index = 0 // индекс (number_q номер)вопроса
        n_q_index = 0 // индекс номера количества ответов
        testNextQuestion(index)//Добавляем первый вопрос во вью
        animat_var = Animations() // создаем обьект класса анимации
        handler = Handler() // создаем обьект Handlera
        btn = findViewById(R.id.btn_close_test)
        r = Runnable {  // создаем запускающийся код
            //Log.d("MyLog", "ИНДЕКС КОЛ-ВА ответов $n_q_index")
            index++ // типа добалвение индекса и смена вопроса для вью
            testNextQuestion(index)
            n_q_index = 0
        } // код - переключающий вопрос на следующий

        bindingButtonsListeners() // биндит слушатели кнопок

        initMobileAdsYandex()
        loadAndShowBanner()
    }

    override fun onResume() {
        super.onResume()
        // загрузка межстраничной рекламы
        loadRewardAdYandex()
    }


    fun checkBind_WhatTheTest(intent: String) {
        if (intent == "new_animaltotem_test") {
            when (questionListsTotemAnimal.im_background) {
                null, 0 -> {
                    im_background = R.drawable.background_night
                } else -> im_background =
                    questionListsTotemAnimal.im_background
            }
            layout_test.setBackgroundResource(im_background)
            list_results_counts = List_resours_an_totem.imIdList
            quests = questionListsTotemAnimal.quest_totem_animal
            minimum_answ = questionListsTotemAnimal.min_nums_ans
            numbers_buttons = questionListsTotemAnimal.answer_nums
            lists_result_add = questionListsTotemAnimal.answer_right_check
            name_button_list = questionListsTotemAnimal.button_name_list
            nums_max_quests = quests.count()

        } else if (intent == "new_dosha_test") {
            when (questionListDoshi.im_background) {
                null, 0 -> {
                    im_background = R.drawable.background_night
                } else -> im_background =
                    questionListDoshi.im_background
            }
            layout_test.setBackgroundResource(im_background)
            list_results_counts = List_Resours_Doshi.imIdList
            quests = questionListDoshi.quest_totem_animal
            minimum_answ = questionListDoshi.min_nums_ans
            numbers_buttons = questionListDoshi.answer_nums
            lists_result_add = questionListDoshi.answer_right_check
            name_button_list = questionListDoshi.button_name_list
            nums_max_quests = quests.count()
        } else {
            Toast.makeText(this, R.string.Test_no_found, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun constructorQuestObj(
        index: Int, quests: Array<String>, numbers_buttons: Array<Int>,
        nums_max_quests: Int, lists_result_add: Array<Array<Array<Int>>>,
        name_button_list: Array<Array<String>>,
        minimum_answ: Array<Int>
    ): questionsBindShablon {
        return questionsBindShablon(
            index,
            quests[index],
            numbers_buttons[index],
            nums_max_quests,
            lists_result_add[index],
            name_button_list[index],
            minimum_answ[index]
        )
    }

    fun constructorResultBindShablon(
        index: Int,
        lists_result_add: Array<Array<Array<Int>>>,
        min_nums_ans: Array<Int>
    ): resultBindShablon {
        return resultBindShablon(
            index,
            lists_result_add[index],
            min_nums_ans[index]
        )
    }

    fun testNextQuestion(index: Int) {
        val view: View = findViewById(R.id.layout_test)
        if (index < nums_max_quests) {
            val shablon = constructorQuestObj(
                index,
                quests,
                numbers_buttons,
                nums_max_quests,
                lists_result_add,
                name_button_list,
                minimum_answ
            )
            shablon.resetBindView(view)
            shablon.bindingView(view,what_the_test)
            shablon.bindNameBtn(view)
        } else {
            Log.d("MyLog", "End test. Дальше не будет биндинга вью вопросника")
            view.btn_close_testfor_result.visibility = View.VISIBLE
            view.btn_column1.visibility = View.GONE
            view.btn_column2.visibility = View.GONE
            view.btn_column3.visibility = View.GONE
            view.btn_close_test.visibility = View.GONE
            view.tv_text_quest.text = getString(R.string.measuring_result)

        }
    }

    fun resultUpdate(btn_id: Int, index: Int) {
        if (index < nums_max_quests) {
            val shablonResultUpdater =
                constructorResultBindShablon(index, lists_result_add, minimum_answ)
            test_res_list = shablonResultUpdater.bindAction(btn_id, test_res_list)
            Log.d("MyLog", "$index индекс вопроса затем будет еще ш++ )")
        }
        if (index == nums_max_quests - 1) {
            Log.d("MyLog", "$index End Result \n" + test_res_list.contentToString())
        }

    }

    fun MinMaxMaxTwoResult(): Array<Int> { // находит из массива результатов
        val min_volume: Int = test_res_list.minByOrNull { it } ?: -1
        val min_name: Int = if (min_volume >= 0) test_res_list.indexOf(min_volume) else -1
        val max_volume: Int = test_res_list.maxByOrNull { it } ?: -1
        val max_name: Int = if (max_volume >= 0) test_res_list.indexOf(max_volume) else -1
        test_res_list[max_name] = -1
        val s_max_volume: Int = test_res_list.maxByOrNull { it } ?: -1
        val s_max_name: Int = if (s_max_volume >= 0) test_res_list.indexOf(s_max_volume) else -1
        test_res_list[max_name] = max_volume
        val all_volume = test_res_list.sum()
        return arrayOf(max_name, max_volume, s_max_name, s_max_volume, min_name, all_volume)

    }

    fun bindingButtonsListeners() {

        btn_ans1.setOnClickListener {
            Log.d("MyLog", "btn1")
            animat_var.anim_btn_ans(btn_ans1)
            resultUpdate(1, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans2.setOnClickListener {
            Log.d("MyLog", "btn2")
            animat_var.anim_btn_ans(btn_ans2)
            resultUpdate(2, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans3.setOnClickListener {
            Log.d("MyLog", "btn3")
            resultUpdate(3, index)
            animat_var.anim_btn_ans(btn_ans3)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans4.setOnClickListener {
            Log.d("MyLog", "btn4")
            animat_var.anim_btn_ans(btn_ans4)
            resultUpdate(4, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans5.setOnClickListener {
            Log.d("MyLog", "btn5")
            animat_var.anim_btn_ans(btn_ans5)
            resultUpdate(5, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans6.setOnClickListener {
            Log.d("MyLog", "btn6")
            animat_var.anim_btn_ans(btn_ans6)
            resultUpdate(6, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans7.setOnClickListener {
            Log.d("MyLog", "btn7")
            animat_var.anim_btn_ans(btn_ans7)
            resultUpdate(7, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans8.setOnClickListener {
            Log.d("MyLog", "btn8")
            animat_var.anim_btn_ans(btn_ans8)
            resultUpdate(8, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 1000)
            }
        }

        btn_ans9.setOnClickListener {
            Log.d("MyLog", "btn9")
            animat_var.anim_btn_ans(btn_ans9)
            resultUpdate(9, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans10.setOnClickListener {
            Log.d("MyLog", "btn10")
            animat_var.anim_btn_ans(btn_ans10)
            resultUpdate(10, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans11.setOnClickListener {
            Log.d("MyLog", "btn11")
            animat_var.anim_btn_ans(btn_ans11)
            resultUpdate(11, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans12.setOnClickListener {
            Log.d("MyLog", "btn12")
            animat_var.anim_btn_ans(btn_ans12)
            resultUpdate(12, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans13.setOnClickListener {
            Log.d("MyLog", "btn13")
            animat_var.anim_btn_ans(btn_ans13)
            resultUpdate(13, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans14.setOnClickListener {
            Log.d("MyLog", "btn14")
            animat_var.anim_btn_ans(btn_ans14)
            resultUpdate(14, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_ans15.setOnClickListener {
            Log.d("MyLog", "btn15")
            animat_var.anim_btn_ans(btn_ans15)
            resultUpdate(15, index)
            n_q_index++
            if (n_q_index == minimum_answ[index]) {
                stopClickForButtons()
                handler.postDelayed(r, 800)
            }
        }

        btn_close_testfor_result.setOnClickListener {
            when (what_the_test) {
                "new_animaltotem_test" ->  showRewardAdYandex()
                "new_dosha_test" -> showRewardAdYandex()
                else -> {
                    Toast.makeText(this, R.string.result_no_found, Toast.LENGTH_SHORT).show()
                }
            }
        }

        btn_close_test.setOnClickListener {
            onBackPressed()
        }
        btn_end_test.setOnClickListener {
            when (what_the_test) {
                "new_animaltotem_test" ->  showRewardAdYandex()
                "new_dosha_test" -> showRewardAdYandex()
                else -> {
                    Toast.makeText(this, R.string.result_no_found, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    var double_back_press = false
    override fun onBackPressed() {
        if (double_back_press == true) {
            super.onBackPressed()
        }
        double_back_press = true
        handler.postDelayed({ double_back_press = false }, 700)

        val aDialog = AlertDialog.Builder(this)
        aDialog.setMessage(R.string.close_test_alert)
            .setCancelable(true)
            .setPositiveButton(
                R.string.Alert_yes,
                DialogInterface.OnClickListener { dialog, id ->
                    setResult(Activity.RESULT_CANCELED)
                    finish()
                })
        aDialog.setNegativeButton(
            R.string.Alert_no,
            DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
        val alert = aDialog.create()
        alert.show()

    }

    fun prepareSavePutResAnimalTest() {
        val first_max_name = MinMaxMaxTwoResult()[0]
        val first_max_volume = MinMaxMaxTwoResult()[1]
        val second_max_name = MinMaxMaxTwoResult()[2]
        val second_max_volume = MinMaxMaxTwoResult()[3]
        val last_min_name = MinMaxMaxTwoResult()[4]
        val all_volume = MinMaxMaxTwoResult()[5]

        intent.putExtra("first_name", first_max_name)
        intent.putExtra("first_volume", first_max_volume)
        intent.putExtra("second_name", second_max_name)
        intent.putExtra("second_volume", second_max_volume)
        intent.putExtra("last_name", last_min_name)
        intent.putExtra("all_volume", all_volume)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun prepareSavePutResDoshaTest() {
        val vataValue = test_res_list[0]
        val pittaValue = test_res_list[1]
        val kaphaValue = test_res_list[2]
        Log.d("MyLog","prepareSavePutResDoshaTest : $vataValue, $pittaValue, $kaphaValue" +
                "" )


        intent.putExtra("dosha_vata", vataValue)
        intent.putExtra("dosha_pitta", pittaValue)
        intent.putExtra("dosha_kapha", kaphaValue)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }



    fun stopClickForButtons() {
        btn_ans1.isClickable = false
        btn_ans2.isClickable = false
        btn_ans3.isClickable = false
        btn_ans4.isClickable = false
        btn_ans5.isClickable = false
        btn_ans6.isClickable = false
        btn_ans7.isClickable = false
        btn_ans8.isClickable = false
        btn_ans9.isClickable = false
        btn_ans10.isClickable = false
        btn_ans11.isClickable = false
        btn_ans12.isClickable = false
        btn_ans13.isClickable = false
        btn_ans14.isClickable = false
        btn_ans15.isClickable = false


    }

    fun loadAndShowBanner() {
        starttest_banner_yandex.apply {
            setAdUnitId(getString(R.string.yandex_banner_id_test))
            setAdSize(AdSize.BANNER_320x50)
        }
        val adRequest = AdRequest.Builder().build()

        starttest_banner_yandex.setBannerAdEventListener(object : BannerAdEventListener {
            override fun onAdLoaded() {
                Log.d("MyLog", "Ad Loaded Ok")
            }

            override fun onAdFailedToLoad(p0: AdRequestError) {
                Log.d("MyLog", "Banner Ad Load Fail")
            }

            override fun onAdClicked() {
                Log.d("MyLog", "Ad Clicked")
            }

            override fun onLeftApplication() {
            }

            override fun onReturnedToApplication() {
            }

            override fun onImpression(p0: ImpressionData?) {
            }
        })
        starttest_banner_yandex.loadAd(adRequest)
    }

    fun initMobileAdsYandex() {
        MobileAds.initialize(this) { Log.d("MyLog", "SDK Initialised OK") }
    }


    private fun loadRewardAdYandex() {
        yandexRewardAd = RewardedAd(this)
        yandexRewardAd.setAdUnitId(getString(R.string.yandex_reward_id_test))
        val adRequest: AdRequest = AdRequest.Builder().build()
        yandexRewardAd.setRewardedAdEventListener(object : RewardedAdEventListener {
            override fun onAdLoaded() {
                Log.d("MyLogAd", "Ad Reward is Loaded")
            }

            override fun onAdFailedToLoad(p0: AdRequestError) {
                Log.d("MyLogAd", p0.toString())
            }

            override fun onAdShown() {

            }

            override fun onAdDismissed() {

            }

            override fun onRewarded(p0: Reward) {

            }

            override fun onAdClicked() {

            }

            override fun onLeftApplication() {

            }

            override fun onReturnedToApplication() {

            }

            override fun onImpression(p0: ImpressionData?) {

            }

        })
        yandexRewardAd.loadAd(adRequest)
        Log.d("MyLogAd", "reward ad Loading")
    }

    private fun showRewardAdYandex() {
        if (yandexRewardAd.isLoaded) {
            if (what_the_test == "new_animaltotem_test") {
                yandexRewardAd.show()
                prepareSavePutResAnimalTest()
            } else if (what_the_test == "new_dosha_test") {
                yandexRewardAd.show()
                prepareSavePutResDoshaTest()
            }
        } else {
            if (what_the_test == "new_animaltotem_test") {
                prepareSavePutResAnimalTest()
            } else if (what_the_test == "new_dosha_test") {
                prepareSavePutResDoshaTest()
            }


        }
    }
}

