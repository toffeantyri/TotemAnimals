package com.example.totemanimals
import androidx.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity_ApComAct : AppCompatActivity() {

    fun setUpPreference(): String {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val pref0 = pref.getString("last_test_result", "nobodyGet")!!
        //берем строку из preference (в первый раз - будет дефолтное значение) пока не пройдешь Тест
        return pref0
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
                    Log.d("MyLog",
                        "count:${list_resours.imIdList.count()} " +
                                "Количество итемов: ${rcView_AnList.layoutManager?.itemCount}   "
                    )

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.my_info_frame, fragment_info()).commit()
                    my_info_frame.visibility = View.VISIBLE
                }
                R.id.exit_menu_id -> {
                    finish()
                }
            }
            true
        }
    }

}