package eu.napcode.android_for_dummies.sendImage.guide.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.internal.BottomNavigationMenuView
import android.view.*
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import eu.napcode.android_for_dummies.sendImage.guide.SendImageGuideActivity
import kotlinx.android.synthetic.main.fragment_share_from_image_preview2.*

var OVERLAY_ACTIVITY_REQUEST_CODE_BOTTOM_SHARE = 104

class ShareFromImagePreviewFragment2 : BaseFragmentStep() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_from_image_preview2, container, false)
    }

    override fun onSelected() {
        (activity as SendImageGuideActivity).hideActions()

        showView(getString(R.string.share2_tip))
    }

    fun showView(text: String) {
        var shareButton = (bottomNavigationView.getChildAt(0) as BottomNavigationMenuView).getChildAt(0)
        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_ELEMENT_LEFT_KEY, shareButton.left)
        intent.putExtra(SHOW_VIEW_ELEMENT_TOP_KEY, bottomNavigationView.top)
        intent.putExtra(SHOW_VIEW_ELEMENT_RIGHT_KEY, shareButton.right)
        intent.putExtra(SHOW_VIEW_ELEMENT_BOTTOM_KEY, bottomNavigationView.bottom)
        intent.putExtra(DISPLAY_TEXT_VALUE_KEY, text)
        intent.putExtra(DISPLAY_TEXT_PLACE_KEY, DISPLAY_TEXT_TOP)

        startActivityForResult(intent, OVERLAY_ACTIVITY_REQUEST_CODE_BOTTOM_SHARE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_CANCELED) {
            activity!!.finish()

            return
        }

        when (requestCode) {
            OVERLAY_ACTIVITY_REQUEST_CODE_BOTTOM_SHARE -> {
                onProceedListener.onProceed()
            }
        }
    }
}


