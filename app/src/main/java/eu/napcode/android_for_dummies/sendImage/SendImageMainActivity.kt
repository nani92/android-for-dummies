package eu.napcode.android_for_dummies.sendImage

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.sendImage.guide.SendImageGuideActivity
import eu.napcode.android_for_dummies.sendImage.help.HelpSendImageActivity
import kotlinx.android.synthetic.main.activity_send_image_main.*

class SendImageMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_image_main)

        showHowToSendImageButton.setOnClickListener { startActivity(Intent(this, SendImageGuideActivity::class.java)) }
        helpMeSendImageButton.setOnClickListener{startActivity(Intent(this, HelpSendImageActivity::class.java))}
    }
}