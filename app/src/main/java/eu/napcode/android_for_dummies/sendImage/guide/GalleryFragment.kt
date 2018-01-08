package eu.napcode.android_for_dummies.sendImage.guide

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R


class GalleryFragment : Fragment(), Step {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_send_image_guide_gallery, container, false)
    }

    override fun verifyStep(): VerificationError? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: VerificationError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSelected() {
        //TODO implement
    }
}