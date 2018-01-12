package eu.napcode.android_for_dummies.sendImage

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.util.Log
import android.util.TypedValue
import android.view.Window
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.ANIMATION_SHORT_DELAY
import eu.napcode.android_for_dummies.base.ANIMATION_SHORT_DURATION
import eu.napcode.android_for_dummies.base.ANIMATION_STANDARD_DURATION
import eu.napcode.android_for_dummies.sendImage.guide.SendImageGuideActivity
import eu.napcode.android_for_dummies.sendImage.help.HelpSendImageActivity
import kotlinx.android.synthetic.main.activity_overlay.*
import kotlinx.android.synthetic.main.send_image_main_content.*
import kotlinx.android.synthetic.main.help_entry_main_toolbar.*

class SendImageMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContentView(R.layout.activity_send_image_main)

        window.enterTransition = Fade().setDuration(ANIMATION_STANDARD_DURATION)

        showHowToSendImageButton.setOnClickListener { startActivity(Intent(this, SendImageGuideActivity::class.java), ActivityOptions.makeSceneTransitionAnimation(this).toBundle()) }
        helpMeSendImageButton.setOnClickListener { startActivity(Intent(this, HelpSendImageActivity::class.java)) }

        setupToolbarTitle()
    }

    fun setupToolbarTitle() {
        helpEntryToolbarTitle_textView.text = getString(R.string.send_image_help_entry_name)
//        var endSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                resources.getDimension(R.dimen.title_text_size), resources.displayMetrics)
//
//        Log.d("Natalia", "s " + helpEntryToolbarTitle_textView.textSize + " " + endSize)
//
//        val titleAnimation = ValueAnimator.ofFloat(helpEntryToolbarTitle_textView.textSize, endSize)
//        titleAnimation.duration = ANIMATION_SHORT_DURATION
//
//        titleAnimation.addUpdateListener {
//            ValueAnimator.AnimatorUpdateListener { value ->
//                Log.d("Natalia", "update " + value.animatedValue)
//                helpEntryToolbarTitle_textView.textSize = value.animatedValue as Float
//                Log.d("Natalia", "update " + value.animatedValue)
//            }
//        }
//
//        titleAnimation.start()
        //TODO ^Not working
    }

    override fun onBackPressed() {
        supportFinishAfterTransition()
    }
}