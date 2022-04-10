package com.totems.totemanimals.view.mainAdapters.Preference

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.totems.totemanimals.viewModel.DataModelTestResult

class AppPreference(context0: Context, dataModel0: DataModelTestResult) {

    private val context = context0
    private val dataModel = dataModel0
    private val data : SharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)

    fun loadPreferenceResultAnimalsToViewModel(){
        val pref_state = 0 //
        // состояние фрагмента тест результ. 0 - все результаты закрыты, 1 - результат AnimalResult - Открыт
        //2- результат теста дош открыт
        //берем строку из preference (в первый раз - будет дефолтное значение) пока не пройдешь Тест
        //префы для теста Тотемное животное
        val data0 = data.getInt("first_name", -1)
        val data1 = data.getInt("first_volume", -1)
        val data2 = data.getInt("second_name", -1)
        val data3 = data.getInt("second_volume", -1)
        val data4 = data.getInt("last_name", -1)
        val data5 = data.getInt("all_volume", -1)

        dataModel.stateOpenTestAnimal.value = pref_state

        dataModel.resultTotemTest.value?.clear()
        dataModel.resultTotemTest.value?.add(data0)
        dataModel.resultTotemTest.value?.add(data1)
        dataModel.resultTotemTest.value?.add(data2)
        dataModel.resultTotemTest.value?.add(data3)
        dataModel.resultTotemTest.value?.add(data4)
        dataModel.resultTotemTest.value?.add(data5)
    }

    fun loadPreferenceResultDoshiToViewModel(){
        //префы для теста Доши
        val pref1 = data.getInt("dosha_vata", -1)
        val pref2 = data.getInt("dosha_pitta", -1)
        val pref3 = data.getInt("dosha_kapha", -1)
        dataModel.resultDoshaTest.value?.clear()
        dataModel.resultDoshaTest.value?.add(pref1)
        dataModel.resultDoshaTest.value?.add(pref2)
        dataModel.resultDoshaTest.value?.add(pref3)
    }


    fun saveAllResultsToPreference(){
        val listAnimals = dataModel.resultTotemTest.value
        val listDoshas = dataModel.resultDoshaTest.value
        if (listAnimals != null) {
            data.edit().putInt("first_name", listAnimals[0]).apply()
            data.edit().putInt("first_volume", listAnimals[1]).apply()
            data.edit().putInt("second_name", listAnimals[2]).apply()
            data.edit().putInt("second_volume", listAnimals[3]).apply()
            data.edit().putInt("last_name", listAnimals[4]).apply()
            data.edit().putInt("all_volume", listAnimals[5]).apply()
        }
        if (listDoshas != null){
            data.edit().putInt("dosha_vata", listDoshas[0]).apply()
            data.edit().putInt("dosha_pitta", listDoshas[1]).apply()
            data.edit().putInt("dosha_kapha", listDoshas[2]).apply()
        }
    }
}