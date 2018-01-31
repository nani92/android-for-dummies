package eu.napcode.android_for_dummies.sendImage.guide.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.internal.BottomNavigationMenuView
import android.view.*
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import eu.napcode.android_for_dummies.sendImage.guide.OrientationGuideActivity
import eu.napcode.android_for_dummies.sendImage.guide.SendImageGuideActivity
import kotlinx.android.synthetic.main.fragment_share_from_image_preview2.*

var OVERLAY_ACTIVITY_REQUEST_CODE_BOTTOM_SHARE = 104

class ShareFromImagePreviewFragment2 : BaseFragmentStep() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_from_image_preview2, container, false)
    }

    override fun onSelected() {
        (activity as SendImageGuideActivity).hideActions()

        var shareButton = (bottomNavigationView.getChildAt(0) as BottomNavigationMenuView).getChildAt(0)
        showView(getString(R.string.share2_tip), shareButton)

        shareButton.setOnClickListener({ getCustomToast(context!!, R.string.clicked_on_share).show() })
    }

    fun showView(text: String, shareButton: View) {
        var overlayHelper = OverlayViewHelper(context!!)
        overlayHelper.left = shareButton.left
        overlayHelper.top = bottomNavigationView.top
        overlayHelper.right = shareButton.right
        overlayHelper.bottom = bottomNavigationView.bottom
        overlayHelper.message = text
        overlayHelper.displayTextTop()

        startActivityForResult(overlayHelper.getOverlayIntent(), OVERLAY_ACTIVITY_REQUEST_CODE_BOTTOM_SHARE)
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


