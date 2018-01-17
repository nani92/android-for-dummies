package eu.napcode.android_for_dummies.sendImage.guide.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import eu.napcode.android_for_dummies.sendImage.guide.SendImageGuideActivity
import kotlinx.android.synthetic.main.bottom_sheet_share_constraint_layout.*
import kotlinx.android.synthetic.main.fragment_share_bottom_sheet.*

class ShareBottomSheetFragment : BaseFragmentStep() {

    var OVERLAY_ACTIVITY_REQUEST_CODE_BOTTOM_SHEET = 105

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_bottom_sheet, container, false)
    }

    override fun onSelected() {
        (activity as SendImageGuideActivity).displayedAllGuide = true

        showView()
    }

    fun showView() {
        var overlayHelper = OverlayViewHelper(context!!)
        overlayHelper.left = bottomSheet_constraintLayout.left
        overlayHelper.top = bottomSheet_constraintLayout.top
        overlayHelper.right = bottomSheet_constraintLayout.right
        overlayHelper.bottom = coordinatorLayout.bottom
        overlayHelper.message = getString(R.string.share_bottom_sheet_tip)
        overlayHelper.displayTextTop()

        startActivityForResult(overlayHelper.getOverlayIntent(), OVERLAY_ACTIVITY_REQUEST_CODE_BOTTOM_SHEET)
    }
}