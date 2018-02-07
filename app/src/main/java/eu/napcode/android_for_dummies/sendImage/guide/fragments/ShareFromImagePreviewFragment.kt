package eu.napcode.android_for_dummies.sendImage.guide.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.*
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import eu.napcode.android_for_dummies.overlay.utils.OverlayViewHelper
import eu.napcode.android_for_dummies.sendImage.guide.SendImageGuideActivity

var OVERLAY_ACTIVITY_REQUEST_CODE_SHARE = 101
var OVERLAY_ACTIVITY_REQUEST_CODE_MORE = 102

class ShareFromImagePreviewFragment : BaseFragmentStep() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_from_image_preview, container, false)
    }

    override fun onSelected() {
        setMenuVisibility(false)

        (activity as SendImageGuideActivity).displayShareAction()
        showView(OVERLAY_ACTIVITY_REQUEST_CODE_SHARE,
                (activity as SendImageGuideActivity).getShareActionRect(),
                getString(R.string.share_tip))
    }

    fun showView(requestCode: Int, rect: Rect, text: String) {
        var overlayHelper = OverlayViewHelper(context!!,
                rect.left, rect.top, rect.right, rect.bottom)
        overlayHelper.message = text

        startActivityForResult(overlayHelper.getOverlayIntent(), requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_CANCELED) {
            activity!!.finish()

            return
        }

        when (requestCode) {

            OVERLAY_ACTIVITY_REQUEST_CODE_SHARE -> {
                (activity as SendImageGuideActivity).displayMoreAction()
                showView(OVERLAY_ACTIVITY_REQUEST_CODE_MORE,
                        (activity as SendImageGuideActivity).getMoreActionRect(),
                        getString(R.string.more_tip))
            }

            OVERLAY_ACTIVITY_REQUEST_CODE_MORE -> {
                onProceedListener.onProceed()
            }
        }
    }
}


