package eu.napcode.android_for_dummies.sendImage.guide

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import eu.napcode.android_for_dummies.R
import kotlinx.android.synthetic.main.activity_send_image_guide.*

class SendImageGuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_image_guide)

        setSupportActionBar(toolbar)
        supportActionBar!!.show()

        stepperLayout.adapter = SendImageGuideStepperAdapter(supportFragmentManager, this)
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
}