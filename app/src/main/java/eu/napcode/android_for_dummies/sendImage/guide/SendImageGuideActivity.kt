package eu.napcode.android_for_dummies.sendImage.guide

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.stepstone.stepper.StepperLayout
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.OnProceedListener
import kotlinx.android.synthetic.main.activity_send_image_guide.*

class SendImageGuideActivity : AppCompatActivity(), OnProceedListener, StepperLayout.StepperListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_image_guide)

        setSupportActionBar(toolbar)
        supportActionBar!!.show()

        stepperLayout.adapter = SendImageGuideStepperAdapter(supportFragmentManager, this)
        stepperLayout.setListener(this)
    }

    fun displayTitle(titleId: Int) {
        supportActionBar!!.title = getString(titleId)
    }

    fun displayShareAction() {
        toolbar.findViewById<ImageView>(R.id.shareImageButton).visibility = View.VISIBLE
    }

    fun displayMoreAction() {
        toolbar.findViewById<ImageView>(R.id.moreImageButton).visibility = View.VISIBLE
    }

    fun getShareActionRect() : Rect {
        var imageButton = toolbar.findViewById<ImageView>(R.id.shareImageButton)

        return getRectFromView(imageButton)
    }

    fun getRectFromView(view: View) : Rect {
        val location = IntArray(2)
        view.getLocationOnScreen(location)

        return Rect(location[0], 0, location[0] + view.width, view.height)
    }

    fun getMoreActionRect() : Rect {
        var imageButton = toolbar.findViewById<ImageView>(R.id.moreImageButton)

        return getRectFromView(imageButton)
    }

    override fun onProceed() {
        stepperLayout.proceed()
    }

    override fun onStepSelected(newStepPosition: Int) {}

    override fun onCompleted(completeButton: View?) {
     //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onReturn() {}

    override fun onError(verificationError: VerificationError?) {}
}