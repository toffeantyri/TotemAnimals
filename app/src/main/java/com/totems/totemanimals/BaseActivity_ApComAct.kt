package com.totems.totemanimals

import android.content.DialogInterface
import androidx.preference.PreferenceManager
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.totems.totemanimals.view.mainActivityFragments.Fragment_info
import com.totems.totemanimals.view.mainActivityFragments.MainSearchFragment
import com.totems.totemanimals.view.mainActivityFragments.fragment_testResult
import com.totems.totemanimals.viewModel.DataModelTestResult
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity_ApComAct : AppCompatActivity() {

    val dataModel: DataModelTestResult by viewModels()
    // инициализация ВьюМоделКласса для активити! - от viewModels!!!!!!! фрагмент будет от activityViewModels

    fun setUpPreference() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val pref_state = 0 //
        // состояние фрагмента тест результ. 0 - все результаты закрыты, 1 - результат AnimalResult - Открыт
        //2- результат теста дош открыт
        //берем строку из preference (в первый раз - будет дефолтное значение) пока не пройдешь Тест
        //префы для теста Тотемное животное
        val pref0 = pref.getInt("first_name", -1)
        val pref1 = pref.getInt("first_volume", -1)
        val pref2 = pref.getInt("second_name", -1)
        val pref3 = pref.getInt("second_volume", -1)
        val pref4 = pref.getInt("last_name", -1)
        val pref5 = pref.getInt("all_volume", -1)
        dataModel.stateOpenTestAnimal.value = pref_state

        dataModel.resultTotemTest.value?.clear()
        dataModel.resultTotemTest.value?.add(pref0)
        dataModel.resultTotemTest.value?.add(pref1)
        dataModel.resultTotemTest.value?.add(pref2)
        dataModel.resultTotemTest.value?.add(pref3)
        dataModel.resultTotemTest.value?.add(pref4)
        dataModel.resultTotemTest.value?.add(pref5)
    }


    fun setUpPreferenceTwo() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        //состояние открытости закрытости результатов теста - в SetUpPreference()
        //префы для теста Доши
        val pref1 = pref.getInt("dosha_vata", -1)
        val pref2 = pref.getInt("dosha_pitta", -1)
        val pref3 = pref.getInt("dosha_kapha", -1)
        dataModel.resultDoshaTest.value?.clear()
        dataModel.resultDoshaTest.value?.add(pref1)
        dataModel.resultDoshaTest.value?.add(pref2)
        dataModel.resultDoshaTest.value?.add(pref3)
    }


    //установка действия для кнопок боттом меню
    fun setUpBottomNavigationMenu() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_info_frame, Fragment_info()) // это для прогрузки фрагмент инфо до загрузки
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_testResult_frame,fragment_testResult.newInstance()).commit()

        nav_bottom_menu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_menu_id -> {
                    my_testResult_frame.visibility = View.VISIBLE
                    my_info_frame.visibility = View.GONE
                    my_search_frame.visibility = View.GONE
                    if(supportFragmentManager.findFragmentById(R.id.my_testResult_frame) == null) {
                        supportFragmentManager.beginTransaction()
                            .replace(
                                R.id.my_testResult_frame,
                                fragment_testResult.newInstance()
                            ).commit()
                    }
                }

                R.id.search_menu_id -> {
                    dataModel.stateOpenTestAnimal.value = 0
                    my_search_frame.visibility = View.VISIBLE
                    my_info_frame.visibility = View.GONE
                    my_testResult_frame.visibility = View.GONE
                    if(supportFragmentManager.findFragmentById(R.id.my_search_frame) == null) {
                        supportFragmentManager.beginTransaction()
                            .replace(
                                R.id.my_search_frame,
                                MainSearchFragment()
                            ).commit()
                    }
                }

                R.id.info_menu_id -> {
                    dataModel.stateOpenTestAnimal.value = 0
                    my_info_frame.visibility = View.VISIBLE
                    my_testResult_frame.visibility = View.GONE
                    my_search_frame.visibility = View.GONE
                    if(supportFragmentManager.findFragmentById(R.id.my_info_frame) == null) {
                        supportFragmentManager.beginTransaction()
                            .replace(
                                R.id.my_info_frame,
                                Fragment_info()
                            ).commit()
                    }
                }
                R.id.exit_menu_id -> {
                    dataModel.stateOpenTestAnimal.value = 0
                    val aDialog = AlertDialog.Builder(this)
                    aDialog.setMessage(R.string.Alert_message_exit)
                        .setCancelable(false)
                        .setNegativeButton(
                            R.string.Alert_no,
                            DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
                        .setPositiveButton(
                            R.string.Alert_yes,
                            DialogInterface.OnClickListener { dialog, id -> finish() })

                    val alert = aDialog.create()
                    alert.show()

                }
            }
            true
        }
    }

}