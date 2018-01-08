package eu.napcode.android_for_dummies.sendImage.guide

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*

var OVERLAY_ACTIVITY_REQUEST_CODE_SHARE = 101
var OVERLAY_ACTIVITY_REQUEST_CODE_MORE = 102

class ShareFromImagePreviewFragment : Fragment(), Step {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_from_image_preview, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.image_preview_menu, menu)
    }

    override fun onSelected() {
        setMenuVisibility(false)
        (activity as SendImageGuideActivity).displayTitle(R.string.gallery)

        (activity as SendImageGuideActivity).displayShareAction()
        showView(OVERLAY_ACTIVITY_REQUEST_CODE_SHARE,
                (activity as SendImageGuideActivity).getShareActionRect(),
                getString(R.string.share_tip))
    }

    fun showView(requestCode: Int, rect: Rect, text: String) {
        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_ELEMENT_LEFT_KEY, rect.left)
        intent.putExtra(SHOW_VIEW_ELEMENT_TOP_KEY, rect.top)
        intent.putExtra(SHOW_VIEW_ELEMENT_RIGHT_KEY, rect.right)
        intent.putExtra(SHOW_VIEW_ELEMENT_BOTTOM_KEY, rect.bottom)
        intent.putExtra(DISPLAY_TEXT_VALUE_KEY, text)

        startActivityForResult(intent, requestCode)
    }

    override fun verifyStep(): VerificationError? = null

    override fun onError(error: VerificationError) {}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {

            OVERLAY_ACTIVITY_REQUEST_CODE_SHARE -> {
                (activity as SendImageGuideActivity).displayMoreAction()
                showView(OVERLAY_ACTIVITY_REQUEST_CODE_MORE,
                        (activity as SendImageGuideActivity).getMoreActionRect(),
                        getString(R.string.more_tip))
            }
        }
    }
}


