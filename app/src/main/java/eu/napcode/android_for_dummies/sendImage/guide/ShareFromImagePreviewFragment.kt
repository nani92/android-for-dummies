package eu.napcode.android_for_dummies.sendImage.guide

import android.app.ActionBar
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import android.widget.ImageView
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*

var OVERLAY_ACTIVITY_REQUEST_CODE_SHARE = 101
var OVERLAY_ACTIVITY_REQUEST_CODE_SETTINGS = 102

class ShareFromImagePreviewFragment : Fragment(), Step {

    lateinit var shareView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()

        setMenuVisibility(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_from_image_preview, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.image_preview_menu, menu)

        shareView = menu!!.findItem(R.id.share).actionView as ImageView
        shareView!!.setImageResource(R.drawable.ic_action_share)
//        Log.d("N", "" + shareView)
//
        shareView.viewTreeObserver.addOnGlobalLayoutListener {
            showView(OVERLAY_ACTIVITY_REQUEST_CODE_SHARE)
            shareView.viewTreeObserver.removeOnGlobalLayoutListener { this }
        }

//        shareView.post({
//            run {
//                showView(OVERLAY_ACTIVITY_REQUEST_CODE_SHARE)
//            }
//        })
    }

    override fun onSelected() {
        (activity as SendImageGuideActivity).displayTitle(R.string.gallery)

        //showRightCorner(OVERLAY_ACTIVITY_REQUEST_CODE_SHARE)
        //showView(OVERLAY_ACTIVITY_REQUEST_CODE_SHARE)
    }

    fun showRightCorner(requestCode: Int) {
        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_RIGHT_CORNER, true)

        startActivityForResult(intent, requestCode)
    }

    fun showView(requestCode: Int) {
        val l = IntArray(2)
        shareView.getLocationOnScreen(l)
        var w = shareView.width

        var left = shareView.left


        Log.d("Nata", "" + l[0] + " " + l[1] +" " + left)

        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_ELEMENT_LEFT_KEY, shareView.left)
        intent.putExtra(SHOW_VIEW_ELEMENT_TOP_KEY, shareView.top)
        intent.putExtra(SHOW_VIEW_ELEMENT_RIGHT_KEY, shareView.right)
        intent.putExtra(SHOW_VIEW_ELEMENT_BOTTOM_KEY, shareView.bottom)

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
            showRightCorner(OVERLAY_ACTIVITY_REQUEST_CODE_SETTINGS)
        }
    }

}

