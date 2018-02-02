package eu.napcode.android_for_dummies.orientation.guideSettings.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import kotlinx.android.synthetic.main.fragment_setting_display.*

class SettingsDisplayFragment : BaseFragmentStep() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_setting_display, container, false)
    }

    override fun onSelected() {
        super.onSelected()

        showOverlayView()
    }

    private fun showOverlayView() {
        var overlayHelper = OverlayViewHelper(context!!,
                deviceRotation_textView.left,
                deviceRotation_textView.top,
                deviceRotation_textView.right,
                deviceRotation_textView.bottom)
        overlayHelper.message = getString(R.string.orientation_tip_find_device_rotation)

        startActivityForResult(overlayHelper.getOverlayIntent(), OVERLAY_ACTIVITY_REQUEST_CODE)
    }

}