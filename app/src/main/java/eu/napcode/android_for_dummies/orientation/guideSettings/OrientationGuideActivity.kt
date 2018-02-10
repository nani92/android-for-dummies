package eu.napcode.android_for_dummies.orientation.guide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.view.View
import android.view.Window
import com.stepstone.stepper.StepperLayout
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.ANIMATION_SHORT_DURATION
import eu.napcode.android_for_dummies.base.OnProceedListener
import kotlinx.android.synthetic.main.activity_orientation_guide.*

class OrientationGuideActivity : AppCompatActivity(), OnProceedListener, StepperLayout.StepperListener {

    var displayedAllGuide = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContentView(R.layout.activity_orientation_guide)
        setSupportActionBar(toolbar)

        window.enterTransition = Explode().setDuration(ANIMATION_SHORT_DURATION)

        stepperLayout.adapter = OrientationGuideStepperAdapter(supportFragmentManager, this)
        stepperLayout.setListener(this)
    }

    override fun onProceed() {

        if (displayedAllGuide == false) {
            stepperLayout.proceed()
        }
    }

    override fun onStepSelected(newStepPosition: Int) {}

    override fun onCompleted(completeButton: View?) = finish()

    override fun onReturn() {}

    override fun onError(verificationError: VerificationError?) {}
}