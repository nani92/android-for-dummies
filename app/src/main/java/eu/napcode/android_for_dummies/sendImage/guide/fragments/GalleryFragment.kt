package eu.napcode.android_for_dummies.sendImage.guide.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import eu.napcode.android_for_dummies.sendImage.guide.OrientationGuideActivity
import eu.napcode.android_for_dummies.sendImage.guide.SendImageGuideActivity
import kotlinx.android.synthetic.main.fragment_send_image_guide_gallery.*

var OVERLAY_ACTIVITY_REQUEST_CODE_IMAGE = 103

class GalleryFragment : BaseFragmentStep() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_send_image_guide_gallery, container, false)
    }

    override fun onSelected() {
        showOverlayView()
        (activity as SendImageGuideActivity).displayTitle(R.string.gallery)
        (activity as SendImageGuideActivity).hideActions()
    }

    private fun showOverlayView() {
        var overlayHelper = OverlayViewHelper(context!!,
                imageView3.left,
                imageView3.top,
                imageView3.right,
                imageView3.bottom)
        overlayHelper.message = getString(R.string.choose_image_from_gallery_tip)

        startActivityForResult(overlayHelper.getOverlayIntent(), OVERLAY_ACTIVITY_REQUEST_CODE_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_CANCELED) {
            activity!!.finish()

            return
        }

        when (requestCode) {
            OVERLAY_ACTIVITY_REQUEST_CODE_IMAGE -> {
                onProceedListener.onProceed()
            }
        }
    }
}