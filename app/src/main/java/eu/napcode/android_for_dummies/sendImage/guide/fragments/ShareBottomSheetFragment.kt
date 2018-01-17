package eu.napcode.android_for_dummies.sendImage.guide.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.BaseFragmentStep
import eu.napcode.android_for_dummies.sendImage.guide.SendImageGuideActivity

class ShareBottomSheetFragment : BaseFragmentStep() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_bottom_sheet, container, false)
    }

    override fun onSelected() {
        (activity as SendImageGuideActivity).displayedAllGuide = true
    }
}