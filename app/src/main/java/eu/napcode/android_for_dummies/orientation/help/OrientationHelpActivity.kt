package eu.napcode.android_for_dummies.orientation.help

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import eu.napcode.android_for_dummies.R
import kotlinx.android.synthetic.main.activity_orientation_help.*
import android.content.Intent
import android.net.Uri
import android.view.View


class OrientationHelpActivity : AppCompatActivity() {

    private var setting: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orientation_help)

        orientationCurrentStateValue_textView.text = getCurrentOrientationSettingMessage()

        changeOrientation_button.setOnClickListener({
            changeOrientation()
            orientationCurrentStateValue_textView.text = getCurrentOrientationSettingMessage()
        })

        giveSaveSettingsPermissions_button.setOnClickListener({showSettingsWritePermissionActivity()})
    }

    private fun getCurrentOrientationSettingMessage(): String {
        setting = Settings.System.getInt(contentResolver, Settings.System.ACCELEROMETER_ROTATION)
        return if (setting == 0) {
            getString(R.string.orientation_option_portrait)
        } else {
            getString(R.string.orientation_option_rotate)
        }
    }

    private fun changeOrientation() {

        if (hasPermissionToWriteSettings()) {
            var desiredSetting = if (setting == 0) 1 else 0
            Settings.System.putInt(contentResolver, Settings.System.ACCELEROMETER_ROTATION, desiredSetting)
        } else {
            setupViewsAccordinglyToPermissions()
        }
    }

    private fun hasPermissionToWriteSettings(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Settings.System.canWrite(this)
        } else {
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
        }
    }

    private fun showSettingsWritePermissionActivity() {
        val intent = Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS)
        intent.data = Uri.parse("package:" + packageName)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

        setupViewsAccordinglyToPermissions()
    }

    private fun setupViewsAccordinglyToPermissions() {

        if (hasPermissionToWriteSettings()) {
            noSaveSettingsGrantedPermissions_textView.visibility = View.GONE
            giveSaveSettingsPermissions_button.visibility = View.GONE
            changeOrientation_button.isEnabled = true
        } else {
            noSaveSettingsGrantedPermissions_textView.visibility = View.VISIBLE
            giveSaveSettingsPermissions_button.visibility = View.VISIBLE
            changeOrientation_button.isEnabled = false
        }
    }
}
