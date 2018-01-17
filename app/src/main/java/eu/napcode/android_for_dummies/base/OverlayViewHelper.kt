package eu.napcode.android_for_dummies.base

import android.content.Context
import android.content.Intent

class OverlayViewHelper {

    var context: Context
    var message: String = ""
    var left: Int? = null
    var top: Int? = null
    var right: Int? = null
    var bottom: Int? = null
    var textDisplayPlace = DISPLAY_TEXT_BOTTOM

    constructor(context: Context) {
        this.context = context
    }

    constructor(context: Context, left: Int, top: Int, right: Int, bottom: Int) {
        this.context =context
        this.left = left
        this.top = top
        this.right = right
        this.bottom = bottom
    }

    fun getOverlayIntent() : Intent {
        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_ELEMENT_LEFT_KEY, left)
        intent.putExtra(SHOW_VIEW_ELEMENT_TOP_KEY, top)
        intent.putExtra(SHOW_VIEW_ELEMENT_RIGHT_KEY, right)
        intent.putExtra(SHOW_VIEW_ELEMENT_BOTTOM_KEY, bottom)
        intent.putExtra(DISPLAY_TEXT_VALUE_KEY, message)
        intent.putExtra(DISPLAY_TEXT_PLACE_KEY, textDisplayPlace)

        return intent
    }

    fun displayTextTop() {
        textDisplayPlace = DISPLAY_TEXT_TOP
    }
}