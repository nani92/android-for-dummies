package eu.napcode.android_for_dummies.sendImage.guide.fragments

import eu.napcode.android_for_dummies.base.BaseFragmentStep
import eu.napcode.android_for_dummies.sendImage.guide.SendImageGuideActivity

class ShareBottomSheetFragment : BaseFragmentStep() {

    override fun onSelected() {
        (activity as SendImageGuideActivity).displayedAllGuide = true

    }
}