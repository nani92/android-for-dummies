package eu.napcode.android_for_dummies.orientation.guideSettings.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.*
import kotlinx.android.synthetic.main.fragment_open_settings.*

class OpenSettingsFragment : BaseFragmentStep() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_open_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnClickListener({onProceedListener.onProceed()})
        populateSettingsView()
    }

    fun populateSettingsView() {
        val settingsAppInfo = context!!.packageManager.getApplicationInfo("com.android.settings", 0)
        settings_imageView.setImageDrawable(context!!.packageManager.getApplicationIcon(settingsAppInfo))
        settingLabel_textView.text = context!!.packageManager.getApplicationLabel(settingsAppInfo)
    }
}