package eu.napcode.android_for_dummies.sendImage.guide

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.ActionMenuView
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView


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

        MaterialShowcaseView.Builder(activity)
                .setTarget(menu!!.findItem(R.id.share).actionView)
                .setDismissText("GOT IT")
                .setContentText("This is some amazing feature you should know about")
                .show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onSelected() {
        (activity as SendImageGuideActivity).displayTitle(R.string.gallery)

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun verifyStep(): VerificationError? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: VerificationError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}