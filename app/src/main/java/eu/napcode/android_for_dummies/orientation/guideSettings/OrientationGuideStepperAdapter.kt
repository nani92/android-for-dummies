package eu.napcode.android_for_dummies.orientation.guide

import android.content.Context
import android.support.v4.app.FragmentManager
import com.stepstone.stepper.Step
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter
import eu.napcode.android_for_dummies.orientation.guideSettings.fragments.OpenSettingsFragment
import eu.napcode.android_for_dummies.orientation.guideSettings.fragments.SettingsFragment

class OrientationGuideStepperAdapter(fm: FragmentManager, context: Context) : AbstractFragmentStepAdapter(fm, context) {

    var steps : Array<Step> = arrayOf(
            OpenSettingsFragment(),
            SettingsFragment())

    override fun getCount(): Int = steps.count()

    override fun createStep(position: Int): Step = steps[position]
}
