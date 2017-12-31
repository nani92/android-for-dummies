package eu.napcode.android_for_dummies.sendImage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.stepstone.stepper.StepperLayout
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R

class SendImageGuideActivity : AppCompatActivity(), StepperLayout.StepperListener {
    override fun onStepSelected(newStepPosition: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(verificationError: VerificationError?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onReturn() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCompleted(completeButton: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_image_guide)
    }
}