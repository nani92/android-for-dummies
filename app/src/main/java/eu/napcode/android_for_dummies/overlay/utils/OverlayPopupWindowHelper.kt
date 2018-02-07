package eu.napcode.android_for_dummies.overlay.utils

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.view.Window
import android.widget.PopupWindow

class OverlayPopupWindowHelper(context: Context, popupWindow: PopupWindow, window: Window) : OverlayViewHelper(context) {
    private val location = IntArray(2)
    private val statusBarHeight: Int
    private val width : Int
    private val height : Int

    init {
        popupWindow.contentView.getLocationOnScreen(location)
        width = popupWindow.contentView.measuredWidth
        height = popupWindow.contentView.measuredHeight

        val rectangle = Rect()
        window.decorView.getWindowVisibleDisplayFrame(rectangle)
        statusBarHeight = rectangle.top
    }

    override fun getOverlayIntent(): Intent {
        super.left = location[0]
        super.top = location[1] - statusBarHeight
        super.right = location[0] + width
        super.bottom = location[1] + height - statusBarHeight

        return super.getOverlayIntent()
    }
}