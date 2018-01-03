package eu.napcode.android_for_dummies.sendImage.guide

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.OverlayActivity
import eu.napcode.android_for_dummies.base.SHOW_VIEW_RIGHT_CORNER

class ShareFromImagePreviewFragment : Fragment(), Step {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_from_image_preview, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.image_preview_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onSelected() {
        (activity as SendImageGuideActivity).displayTitle(R.string.gallery)

        var intent = Intent(context, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_RIGHT_CORNER, true)

        startActivity(intent)
    }

    override fun verifyStep(): VerificationError? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: VerificationError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}