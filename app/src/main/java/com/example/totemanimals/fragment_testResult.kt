package com.example.totemanimals

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.preference.PreferenceManager
import com.example.totemanimals.list_resours.imIdList
import kotlinx.android.synthetic.main.fragment_fragment_test_result.*
import kotlinx.android.synthetic.main.fragment_fragment_test_result.view.*

class fragment_testResult : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view0 = LayoutInflater.from(container?.context).inflate(R.layout.fragment_fragment_test_result,container,false)
        val i = arguments?.getString("pref0")
        view0.tv_pref_result.text=i.toString()

        view0.btn_start_test.setOnClickListener {
            val intent = Intent(activity,StartTest_activity::class.java)
            intent.putExtra("newtest", "BTNnewtest")
            startActivityForResult(intent,100)
        }

        Log.d("MyLog", "OnCreateView Fragment_testResult " +  i)
        return view0

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        @JvmStatic
        fun newInstance(pref0: String) : fragment_testResult {
            val fragment = fragment_testResult()
            val args = Bundle()
            args.putString("pref0", pref0)
            fragment.arguments=args
            return fragment}
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        if (requestCode==100 && resultCode==Activity.RESULT_OK && data!=null) {
            pref.edit().putString("last_test_result",data.getStringExtra("result_test")).apply()
            tv_pref_result.text=data.getStringExtra("result_test")
            val animal_construct_result : Animal = animal_construct(data.getIntExtra("result_test_int",-1))
            Log.d("MyLog", animal_construct_result.toString())


        }
        else { Log.d("MyLog", " Старый результат?: " + tv_pref_result.text.toString())
            //tv_pref_result.text=pref.getString("last_test_result","closeNull")
        }
    }

    fun bindingNewResult(animal_constructor_res: Animal) {



    }

    fun animal_construct(number_animal_index: Int) :Animal   //создание обьекта(экземпляра) класса Animal
    {      if(number_animal_index!=(-1)&&number_animal_index<=imIdList.size){
                val animalRes = Animal(
                list_resours.imIdList[number_animal_index], list_resours.nameIdList[number_animal_index],
                list_resours.descriptIdList[number_animal_index])
                return animalRes}
        else return Animal(0,"null_construct", "null_construct")
    }
}



