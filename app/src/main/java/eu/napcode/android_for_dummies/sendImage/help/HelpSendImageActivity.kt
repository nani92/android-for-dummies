package eu.napcode.android_for_dummies.sendImage.help

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.napcode.android_for_dummies.R
import pl.aprilapps.easyphotopicker.EasyImage

class HelpSendImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_send_image)

        EasyImage.openGallery(this, 0)
    }
}
