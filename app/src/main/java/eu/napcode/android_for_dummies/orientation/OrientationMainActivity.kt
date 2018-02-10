package eu.napcode.android_for_dummies.orientation

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.view.Window
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.ANIMATION_STANDARD_DURATION
import eu.napcode.android_for_dummies.notimplemented.NotImplementedActivity
import eu.napcode.android_for_dummies.orientation.guide.OrientationGuideActivity
import eu.napcode.android_for_dummies.orientation.help.OrientationHelpActivity
import kotlinx.android.synthetic.main.orientation_main_content.*
import kotlinx.android.synthetic.main.help_entry_main_toolbar.*

class OrientationMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContentView(R.layout.activity_orientation_main)

        window.enterTransition = Fade().setDuration(ANIMATION_STANDARD_DURATION)

        val transitionBundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()

        showOrientationWithSettings_button.setOnClickListener {
            startActivity(Intent(this, OrientationGuideActivity::class.java), transitionBundle)
        }

        showOrientationWithStatusBar_button.setOnClickListener {
            startActivity(Intent(this, NotImplementedActivity::class.java), transitionBundle)
        }

        helpMeChangeOrientation_button.setOnClickListener {
            startActivity(Intent(this, OrientationHelpActivity::class.java), transitionBundle)
        }

        setupToolbar()
    }

    fun setupToolbar() {
        helpEntryToolbarIcon_imageView.setImageDrawable(getDrawable(R.drawable.he_orientation))
        helpEntryToolbarTitle_textView.text = getString(R.string.orientation_help_entry_name)
    }

    override fun onBackPressed() {
        supportFinishAfterTransition()
    }
}