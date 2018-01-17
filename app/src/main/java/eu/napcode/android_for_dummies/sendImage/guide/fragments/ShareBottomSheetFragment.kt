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
        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_ELEMENT_LEFT_KEY, bottomSheet_constraintLayout.left)
        intent.putExtra(SHOW_VIEW_ELEMENT_TOP_KEY, bottomSheet_constraintLayout.top)
        intent.putExtra(SHOW_VIEW_ELEMENT_RIGHT_KEY, bottomSheet_constraintLayout.right)
        intent.putExtra(SHOW_VIEW_ELEMENT_BOTTOM_KEY, coordinatorLayout.bottom)
        intent.putExtra(DISPLAY_TEXT_PLACE_KEY, DISPLAY_TEXT_TOP)
        intent.putExtra(DISPLAY_TEXT_VALUE_KEY, getString(R.string.share_bottom_sheet_tip))

        startActivityForResult(intent, OVERLAY_ACTIVITY_REQUEST_CODE_BOTTOM_SHEET)
    }
}