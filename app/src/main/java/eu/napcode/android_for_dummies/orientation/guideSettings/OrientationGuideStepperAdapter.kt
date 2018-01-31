package eu.napcode.android_for_dummies.sendImage.guide

import android.content.Context
import android.support.v4.app.FragmentManager
import com.stepstone.stepper.Step
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter
import eu.napcode.android_for_dummies.orientation.guideSettings.fragments.OpenSettingsFragment

class OrientationGuideStepperAdapter(fm: FragmentManager, context: Context) : AbstractFragmentStepAdapter(fm, context) {

    var steps : Array<Step> = arrayOf(OpenSettingsFragment())

    override fun getCount(): Int = steps.count()

    override fun createStep(position: Int): Step = steps[position]
}
