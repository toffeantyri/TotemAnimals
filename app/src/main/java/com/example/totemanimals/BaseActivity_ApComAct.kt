package com.example.totemanimals
import android.content.DialogInterface
import androidx.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.internal.NavigationMenu
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity_ApComAct : AppCompatActivity() {

    fun setUpPreference(): Array<Int> {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val pref_state = 0 // состояние фрагмента тест результ. 0 - все результаты закрыты, 1 - результат AnimalResult - Открыт
        //берем строку из preference (в первый раз - будет дефолтное значение) пока не пройдешь Тест
        //префы для теста Тотемное животное
        val pref0 = pref.getInt("first_name", -1)
        val pref1 = pref.getInt("first_volume", -1)
        val pref2 = pref.getInt("second_name", -1)
        val pref3 = pref.getInt("second_volume", -1)
        val pref4 = pref.getInt("last_name", -1)
        val pref5 = pref.getInt("all_volume", -1)
        //
        return arrayOf(pref_state,pref0,pref1,pref2,pref3,pref4,pref5)
    }

    //установка действия для кнопок боттом меню
    fun setUpBottomNavigationMenu() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_info_frame, fragment_info())
        nav_bottom_menu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_menu_id -> {
                    rcView_AnList.visibility = View.GONE
                    my_info_frame.visibility = View.GONE

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.my_testResult_frame, fragment_testResult.newInstance(setUpPreference())).commit()
                    my_testResult_frame.visibility = View.VISIBLE
                }
                R.id.search_menu_id -> {
                    rcView_AnList.visibility = View.VISIBLE
                    my_info_frame.visibility = View.GONE
                    my_testResult_frame.visibility = View.GONE
                }
                R.id.info_menu_id -> {
                    my_testResult_frame.visibility = View.GONE
                    rcView_AnList.visibility = View.GONE

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.my_info_frame, fragment_info()).commit()
                    my_info_frame.visibility = View.VISIBLE
                }
                R.id.exit_menu_id -> {
                    val aDialog = AlertDialog.Builder(this)

                    aDialog.setMessage(R.string.Alert_message_exit)
                        .setCancelable(false)
                        .setNegativeButton(R.string.Alert_no,DialogInterface.OnClickListener{dialog, id -> dialog.cancel()  })
                        .setPositiveButton(R.string.Alert_yes,DialogInterface.OnClickListener { dialog, id -> finish() })

                    val alert = aDialog.create()
                    alert.show()

                }
            }
            true
        }
    }

}