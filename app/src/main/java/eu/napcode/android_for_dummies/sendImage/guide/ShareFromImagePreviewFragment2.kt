package eu.napcode.android_for_dummies.sendImage.guide

import android.app.Activity
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.support.design.internal.BottomNavigationMenuView
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import kotlinx.android.synthetic.main.fragment_share_from_image_preview2.*

var OVERLAY_ACTIVITY_REQUEST_CODE_BOTTOM_SHARE = 104

class ShareFromImagePreviewFragment2 : Fragment(), Step {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_from_image_preview2, container, false)
    }

    override fun onSelected() {
        (activity as SendImageGuideActivity).displayedAllGuide = true
        (activity as SendImageGuideActivity).hideActions()

        var view = (bottomNavigationView.getChildAt(0) as BottomNavigationMenuView).getChildAt(0)

        Log.d("n", view.toString())
        showView(getString(R.string.share_tip2))
    }

    fun showView(text: String) {
        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_ELEMENT_LEFT_KEY, bottomNavigationView.getChildAt(0).left)
        intent.putExtra(SHOW_VIEW_ELEMENT_TOP_KEY, bottomNavigationView.top)
        intent.putExtra(SHOW_VIEW_ELEMENT_RIGHT_KEY, bottomNavigationView.getChildAt(0).right)
        intent.putExtra(SHOW_VIEW_ELEMENT_BOTTOM_KEY, bottomNavigationView.bottom)
        intent.putExtra(DISPLAY_TEXT_VALUE_KEY, text)

        startActivityForResult(intent, OVERLAY_ACTIVITY_REQUEST_CODE_BOTTOM_SHARE)
    }

    override fun verifyStep(): VerificationError? = null

    override fun onError(error: VerificationError) {}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_CANCELED) {
            activity!!.finish()

            return
        }

        when (requestCode) {

            OVERLAY_ACTIVITY_REQUEST_CODE_SHARE -> {
                //onP
            }
        }
    }
}


