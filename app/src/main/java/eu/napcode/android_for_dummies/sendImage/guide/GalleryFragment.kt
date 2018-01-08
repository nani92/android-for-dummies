package eu.napcode.android_for_dummies.sendImage.guide

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import kotlinx.android.synthetic.main.fragment_send_image_guide_gallery.*


class GalleryFragment : Fragment(), Step {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_send_image_guide_gallery, container, false)
    }

    override fun verifyStep(): VerificationError? {
        //return null when user can go further
        return null
    }

    override fun onError(error: VerificationError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSelected() {
        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_ELEMENT_LEFT_KEY, imageView3.left)
        intent.putExtra(SHOW_VIEW_ELEMENT_TOP_KEY, imageView3.top)
        intent.putExtra(SHOW_VIEW_ELEMENT_RIGHT_KEY, imageView3.right)
        intent.putExtra(SHOW_VIEW_ELEMENT_BOTTOM_KEY, imageView3.bottom)
        intent.putExtra(DISPLAY_TEXT_VALUE_KEY, "D")

        startActivity(intent)
    }
}