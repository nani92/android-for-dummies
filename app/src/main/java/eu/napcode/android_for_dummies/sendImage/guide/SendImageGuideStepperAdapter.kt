package eu.napcode.android_for_dummies.sendImage.guide

import android.content.Context
import android.support.v4.app.FragmentManager
import com.stepstone.stepper.Step
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter

class SendImageGuideStepperAdapter(fm: FragmentManager, context: Context) : AbstractFragmentStepAdapter(fm, context) {

    override fun getCount(): Int = 1

    override fun createStep(position: Int): Step = ShareFromImagePreviewFragment()

}
