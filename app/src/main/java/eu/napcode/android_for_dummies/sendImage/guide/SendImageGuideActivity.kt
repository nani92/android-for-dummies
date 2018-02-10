package eu.napcode.android_for_dummies.sendImage.guide

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.view.Menu
import android.view.View
import android.view.Window
import android.widget.ImageView
import com.stepstone.stepper.StepperLayout
import com.stepstone.stepper.VerificationError
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.ANIMATION_SHORT_DURATION
import eu.napcode.android_for_dummies.base.OnProceedListener
import eu.napcode.android_for_dummies.base.getCustomToast
import kotlinx.android.synthetic.main.activity_send_image_guide.*

class SendImageGuideActivity : AppCompatActivity(), OnProceedListener, StepperLayout.StepperListener {

    var displayedAllGuide = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContentView(R.layout.activity_send_image_guide)

        window.enterTransition = Explode().setDuration(ANIMATION_SHORT_DURATION)

        setSupportActionBar(toolbar)
        supportActionBar!!.show()

        stepperLayout.adapter = SendImageGuideStepperAdapter(supportFragmentManager, this)
        stepperLayout.setListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater!!.inflate(R.menu.image_preview_menu, menu)
        
        return true
    }

    fun displayTitle(titleId: Int) {
        supportActionBar!!.title = getString(titleId)
    }

    fun displayShareAction() {
        toolbar.findViewById<ImageView>(R.id.share_imageView).visibility = View.VISIBLE
        toolbar.findViewById<ImageView>(R.id.more_imageView).setOnClickListener({
            getCustomToast(this, R.string.clicked_on_share).show()
        })
    }

    fun displayMoreAction() {
        toolbar.findViewById<ImageView>(R.id.more_imageView).visibility = View.VISIBLE
        toolbar.findViewById<ImageView>(R.id.more_imageView).setOnClickListener({
            getCustomToast(this, R.string.clicked_on_more).show()
        })
    }

    fun hideActions() {
        toolbar.findViewById<ImageView>(R.id.share_imageView).visibility = View.INVISIBLE
        toolbar.findViewById<ImageView>(R.id.more_imageView).visibility = View.INVISIBLE
    }

    fun getShareActionRect() : Rect {
        var imageButton = toolbar.findViewById<ImageView>(R.id.share_imageView)

        return getRectFromView(imageButton)
    }

    fun getRectFromView(view: View) : Rect {
        val location = IntArray(2)
        view.getLocationOnScreen(location)

        return Rect(location[0], 0, location[0] + view.width, view.height)
    }

    fun getMoreActionRect() : Rect {
        var imageButton = toolbar.findViewById<ImageView>(R.id.more_imageView)

        return getRectFromView(imageButton)
    }

    override fun onProceed() {

        if (displayedAllGuide == false) {
            stepperLayout.proceed()
        }
    }

    override fun onStepSelected(newStepPosition: Int) {}

    override fun onCompleted(completeButton: View?) = finish()

    override fun onReturn() {}

    override fun onError(verificationError: VerificationError?) {}

    fun onShareAppClicked(shareAppImageView: View) = getCustomToast(this, R.string.clicked_on_app_share).show()
}