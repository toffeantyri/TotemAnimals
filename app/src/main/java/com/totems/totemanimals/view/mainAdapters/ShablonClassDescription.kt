package com.totems.totemanimals.view.mainAdapters

import com.totems.totemanimals.R
import java.io.Serializable

open class ShablonClassDescription(open val image: Int = R.drawable.ava_inst1, open val title : String = "Title", open val description : String = "Description") : Serializable {
    val INTENT_KEY_SEARCH = "description_search"
    val INTENT_KEY_RESULT = "description_result"


}