package eu.napcode.android_for_dummies.notimplemented

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.view.Window
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.ANIMATION_SHORT_DURATION

class NotImplementedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContentView(R.layout.activity_not_implemented)
        window.enterTransition = Explode().setDuration(ANIMATION_SHORT_DURATION)
    }
}