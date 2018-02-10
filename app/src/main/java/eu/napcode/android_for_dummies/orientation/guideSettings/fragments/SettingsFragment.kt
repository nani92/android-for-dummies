package eu.napcode.android_for_dummies.orientation.guideSettings.fragments

import android.os.Bundle
import android.view.*
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import eu.napcode.android_for_dummies.overlay.utils.OverlayViewHelper
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragmentStep() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onSelected() {
        super.onSelected()

        showOverlayView(display_textView)
    }
    private fun showOverlayView(view: View) {
        var overlayHelper = OverlayViewHelper(context!!, view)
        overlayHelper.message = getString(R.string.orientation_tip_find_display)

        startActivityForResult(overlayHelper.getOverlayIntent(), OVERLAY_ACTIVITY_REQUEST_CODE)
    }
}