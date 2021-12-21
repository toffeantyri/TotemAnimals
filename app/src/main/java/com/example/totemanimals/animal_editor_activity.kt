package com.example.totemanimals

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_animal_editor_activity.*

class animal_editor_activity : AppCompatActivity() {

    private val imIdList = listOf(R.drawable.smallbelka,R.drawable.smallbober,R.drawable.smallezh,
        R.drawable.smallfilin,R.drawable.smallkon,R.drawable.smalllebed,R.drawable.smalllisa,
        R.drawable.smallmedved,R.drawable.smallolen,R.drawable.smallorel,R.drawable.smallpetuh,
        R.drawable.smallslon,R.drawable.smalltur,R.drawable.smalluzh,R.drawable.smallvolk,)

    private var indexImList = 0
    private var imId = imIdList[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_editor_activity)

        initButtons()
    }
    private fun initButtons() {
        btn_im_next.setOnClickListener {
            indexImList++
            if(indexImList>imIdList.size-1) indexImList = 0
            imId = imIdList[indexImList]
            im_View_changed.setImageResource(imIdList[indexImList])
                    }
        btn_done.setOnClickListener{
            val animal = Animal(imId, ed_title.text.toString(), ed_descrip.text.toString())
            val editIntent = intent.putExtra("animal",animal)
            setResult(Activity.RESULT_OK,editIntent)
            finish()
        }
    }


}
