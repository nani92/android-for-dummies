package eu.napcode.android_for_dummies.orientation.guideSettings.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import kotlinx.android.synthetic.main.fragment_setting_display.*
import android.view.LayoutInflater
import android.widget.PopupWindow
import eu.napcode.android_for_dummies.orientation.guide.OrientationGuideActivity
import eu.napcode.android_for_dummies.overlay.utils.OverlayPopupWindowHelper
import eu.napcode.android_for_dummies.overlay.utils.OverlayViewHelper

var OVERLAY_ACTIVITY_REQUEST_CODE_DEVICE_ROTATION = 106

class SettingsDisplayFragment : BaseFragmentStep() {

    private lateinit var popupWindow : PopupWindow

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        popupWindow = createPopupWindow()

        return inflater.inflate(R.layout.fragment_setting_display, container, false)
    }

    override fun onSelected() {
        super.onSelected()
        (activity as OrientationGuideActivity).displayedAllGuide = true

        showOverlayView(deviceRotation_textView)
    }

    private fun showOverlayView(view: View) {
        var overlayHelper = OverlayViewHelper(context!!, view)
        overlayHelper.message = getString(R.string.orientation_tip_find_device_rotation)

        startActivityForResult(overlayHelper.getOverlayIntent(), OVERLAY_ACTIVITY_REQUEST_CODE_DEVICE_ROTATION)
    }

    fun showMenu(view: View) {

        if (popupWindow.isShowing) {
            return
        }

        popupWindow.showAsDropDown(view)
        popupWindow.contentView.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {

            override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                showPopupOverlay(popupWindow)
                popupWindow.contentView.removeOnLayoutChangeListener(this)
            }
        })
    }

    private fun showPopupOverlay(window: PopupWindow) {
        var overlayHelper = OverlayPopupWindowHelper(this.context!!, window, this.activity!!.window)
        overlayHelper.message = getString(R.string.orientation_tip_choose_option)

        startActivityForResult(overlayHelper.getOverlayIntent(), OVERLAY_ACTIVITY_REQUEST_CODE)
    }

    fun createPopupWindow(): PopupWindow {
        val view: View = layoutInflater
                .inflate(R.layout.popup_menu_layout, null)

        view.setOnClickListener({

            if (popupWindow.isShowing) {
                popupWindow.dismiss()
            }
        })

        return PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_CANCELED) {
            activity!!.finish()

            return
        }

        if (requestCode == OVERLAY_ACTIVITY_REQUEST_CODE_DEVICE_ROTATION) {
            showMenu(deviceRotation_textView)
        } else {
            //TODO would be better to dismiss on step change
            popupWindow.dismiss()
        }
    }
}