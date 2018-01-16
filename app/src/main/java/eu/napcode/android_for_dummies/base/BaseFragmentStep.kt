package eu.napcode.android_for_dummies.base

import android.content.Context
import android.support.v4.app.Fragment
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError

open class BaseFragmentStep : Fragment(), Step {

    lateinit var onProceedListener: OnProceedListener

    override fun onSelected() {}

    override fun verifyStep(): VerificationError? = null

    override fun onError(error: VerificationError) {}

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        onProceedListener = context as OnProceedListener
    }
}
