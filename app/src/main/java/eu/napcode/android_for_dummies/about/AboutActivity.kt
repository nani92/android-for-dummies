package eu.napcode.android_for_dummies.about

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.ANIMATION_STANDARD_DURATION

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        window.enterTransition = Fade().setDuration(ANIMATION_STANDARD_DURATION)

    }
}
