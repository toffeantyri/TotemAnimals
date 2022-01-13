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

    fun setUpPreference(): List<Any> {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val pref0 = pref.getString("last_test_result", "nobodyGetName")!!
        val pref1 = pref.getInt("last_test_result_n", -1)
        val pref2 = pref.getInt("last_test_result_volume", 0)
        //берем строку из preference (в первый раз - будет дефолтное значение) пока не пройдешь Тест
        return listOf(pref0,pref1,pref2)
    }
    fun setUpBottomNavigationMenu() {
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