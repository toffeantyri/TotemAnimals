package com.totems.totemanimals.view


import android.content.DialogInterface
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.totems.totemanimals.R
import com.totems.totemanimals.view.mainActivityFragments.Fragment_info
import com.totems.totemanimals.view.mainActivityFragments.MainSearchFragment
import com.totems.totemanimals.view.mainActivityFragments.fragment_testResult
import com.totems.totemanimals.view.mainAdapters.Preference.AppPreference
import com.totems.totemanimals.viewModel.DataModelTestResult
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity_ApComAct : AppCompatActivity() {


    fun setUpPreferenceToViewModel(preference : AppPreference) {
        preference.loadPreferenceResultAnimalsToViewModel()
        preference.loadPreferenceResultDoshiToViewModel()
    }


    //установка действия для кнопок боттом меню
    fun setUpBottomNavigationMenu(dataModel : DataModelTestResult ) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_info_frame, Fragment_info()) // это для прогрузки фрагмент инфо до загрузки
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_testResult_frame,fragment_testResult.newInstance()).commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_search_frame,MainSearchFragment()).commit()


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