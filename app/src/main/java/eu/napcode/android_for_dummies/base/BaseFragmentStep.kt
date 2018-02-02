package eu.napcode.android_for_dummies.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError

var OVERLAY_ACTIVITY_REQUEST_CODE = 99

open class BaseFragmentStep : Fragment(), Step {

    lateinit var onProceedListener: OnProceedListener

    override fun onSelected() {}

    override fun verifyStep(): VerificationError? = null

    override fun onError(error: VerificationError) {}

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        onProceedListener = context as OnProceedListener
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_CANCELED) {
            activity!!.finish()

            return
        }

        if (requestCode == OVERLAY_ACTIVITY_REQUEST_CODE) {
            onProceedListener.onProceed()
        }
    }
}
