package eu.napcode.android_for_dummies.sendImage.guide

import android.app.ActionBar
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.Toast
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.OverlayActivity
import eu.napcode.android_for_dummies.base.SHOW_VIEW_RIGHT_CORNER

var OVERLAY_ACTIVITY_REQUEST_CODE_SHARE = 101
var OVERLAY_ACTIVITY_REQUEST_CODE_SETTINGS = 102

class ShareFromImagePreviewFragment : Fragment(), Step {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()

      //  setMenuVisibility(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_from_image_preview, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        //inflater!!.inflate(R.menu.image_preview_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onSelected() {
        (activity as SendImageGuideActivity).displayTitle(R.string.gallery)

        showRightCorner(OVERLAY_ACTIVITY_REQUEST_CODE_SHARE)
    }

    fun showRightCorner(requestCode: Int) {
        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_RIGHT_CORNER, true)

        startActivityForResult(intent, requestCode)
    }

    override fun verifyStep(): VerificationError? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: VerificationError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == OVERLAY_ACTIVITY_REQUEST_CODE_SHARE
                && resultCode == Activity.RESULT_OK) {
            Toast.makeText(context, "dupa", Toast.LENGTH_LONG).show()

            if ((activity as AppCompatActivity)!!.supportActionBar != null) {

                (activity as SendImageGuideActivity).openOptionsMenu()
               // (activity as SendImageGuideActivity).invalidateOptionsMenu()
            }

            //showRightCorner(OVERLAY_ACTIVITY_REQUEST_CODE_SETTINGS)
        }
    }
}