package eu.napcode.android_for_dummies.sendImage.guide

import android.content.Context
import android.support.v4.app.FragmentManager
import com.stepstone.stepper.Step
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter

class SendImageGuideStepperAdapter(fm: FragmentManager, context: Context) : AbstractFragmentStepAdapter(fm, context) {

    var steps : Array<Step> = arrayOf(GalleryFragment(),
            ShareFromImagePreviewFragment())

    override fun getCount(): Int = steps.count()

    override fun createStep(position: Int): Step = steps[position]
}
