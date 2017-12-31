package eu.napcode.android_for_dummies.sendImage.guide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.napcode.android_for_dummies.R
import kotlinx.android.synthetic.main.activity_send_image_guide.*

class SendImageGuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_image_guide)

        stepperLayout.adapter = SendImageGuideStepperAdapter(supportFragmentManager, this)
    }
}