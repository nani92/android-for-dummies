package eu.napcode.android_for_dummies.orientation.guideSettings.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragmentStep() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onSelected() {
        super.onSelected()

        showOverlayView()
    }
    private fun showOverlayView() {
        var overlayHelper = OverlayViewHelper(context!!,
                display_textView.left,
                display_textView.top,
                display_textView.right,
                display_textView.bottom)
        overlayHelper.message = getString(R.string.orientation_tip_find_display)

        startActivityForResult(overlayHelper.getOverlayIntent(), OVERLAY_ACTIVITY_REQUEST_CODE)
    }
}