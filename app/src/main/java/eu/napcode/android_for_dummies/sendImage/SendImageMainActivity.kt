package eu.napcode.android_for_dummies.sendImage

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.view.Window
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.sendImage.guide.SendImageGuideActivity
import eu.napcode.android_for_dummies.sendImage.help.HelpSendImageActivity
import kotlinx.android.synthetic.main.send_image_main_content.*

class SendImageMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContentView(R.layout.activity_send_image_main)

        window.enterTransition = Fade().setDuration(1000)

        showHowToSendImageButton.setOnClickListener { startActivity(Intent(this, SendImageGuideActivity::class.java)) }
        helpMeSendImageButton.setOnClickListener{startActivity(Intent(this, HelpSendImageActivity::class.java))}
    }
}