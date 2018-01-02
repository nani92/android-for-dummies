package eu.napcode.android_for_dummies.sendImage.guide

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.OverlayActivity
import eu.napcode.android_for_dummies.base.SHOW_VIEW_ELEMENT_BUNDLE
import eu.napcode.android_for_dummies.base.SHOW_VIEW_ELEMENT_LEFT_KEY
import kotlinx.android.synthetic.main.activity_send_image_guide.*

class SendImageGuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_image_guide)

        stepperLayout.adapter = SendImageGuideStepperAdapter(supportFragmentManager, this)
    }

    fun displayTitle(titleId: Int) {
        supportActionBar!!.title = getString(titleId)
    }

    fun startOverlayActivity(bundle: Bundle) {
        var intent = Intent(this, OverlayActivity::class.java)
        intent.putExtra(SHOW_VIEW_ELEMENT_BUNDLE, bundle)

        startActivity(intent)
    }
}