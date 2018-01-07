package eu.napcode.android_for_dummies.sendImage.guide

import android.app.Activity
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
        setMenuVisibility(false)

        (activity as SendImageGuideActivity).displayShareAction()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_from_image_preview, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.image_preview_menu, menu)
    }

    override fun onSelected() {
        (activity as SendImageGuideActivity).displayTitle(R.string.gallery)

        //showRightCorner(OVERLAY_ACTIVITY_REQUEST_CODE_SHARE)
        showView(OVERLAY_ACTIVITY_REQUEST_CODE_SHARE, (activity as SendImageGuideActivity).getShareActionRect())
    }

    fun showRightCorner(requestCode: Int) {
        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_RIGHT_CORNER, true)

        startActivityForResult(intent, requestCode)
    }

    fun showView(requestCode: Int, rect: Rect) {
        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_ELEMENT_LEFT_KEY, rect.left)
        intent.putExtra(SHOW_VIEW_ELEMENT_TOP_KEY, rect.top)
        intent.putExtra(SHOW_VIEW_ELEMENT_RIGHT_KEY, rect.right)
        intent.putExtra(SHOW_VIEW_ELEMENT_BOTTOM_KEY, rect.bottom)

        startActivityForResult(intent, requestCode)
    }

    override fun verifyStep(): VerificationError? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: VerificationError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == OVERLAY_ACTIVITY_REQUEST_CODE_SHARE
                && resultCode == Activity.RESULT_OK) {

            (activity as SendImageGuideActivity).openOptionsMenu()
            (activity as SendImageGuideActivity).displayMoreAction()
            showView(OVERLAY_ACTIVITY_REQUEST_CODE_MORE, (activity as SendImageGuideActivity).getMoreActionRect())
        }
    }

}

