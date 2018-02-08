package eu.napcode.android_for_dummies.orientation.help

import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import eu.napcode.android_for_dummies.R
import kotlinx.android.synthetic.main.orientation_help_activity.*

class OrientationHelpActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.orientation_help_activity)

        orientationCurrentStateValue_textView.text = getCurrentOrientationSettingMessage()
    }

    fun getCurrentOrientationSettingMessage() : String {
        var setting = Settings.System.getInt(contentResolver, Settings.System.ACCELEROMETER_ROTATION)

        return if (setting == 0) {
            getString(R.string.orientation_option_portrait)
        } else {
            getString(R.string.orientation_option_rotate)
        }
    }
}
