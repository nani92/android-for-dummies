package eu.napcode.android_for_dummies.sendImage.help

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.napcode.android_for_dummies.R
import pl.aprilapps.easyphotopicker.EasyImage
import pl.aprilapps.easyphotopicker.DefaultCallback
import android.content.Intent
import android.graphics.Color
import android.transition.Slide
import android.view.View
import com.bumptech.glide.Glide
import eu.napcode.android_for_dummies.base.ANIMATION_SHORT_DURATION
import kotlinx.android.synthetic.main.activity_help_send_image.*
import java.io.File

class HelpSendImageActivity : AppCompatActivity() {

    var imageFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_send_image)

        window.enterTransition = Slide().setDuration(ANIMATION_SHORT_DURATION)

        chooseImage_button.setOnClickListener({EasyImage.openGallery(this, 0) })
        chooseAppToSendImage_button.setOnClickListener({ shareImage() })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, object : DefaultCallback() {
            override fun onImagePicked(imageFile: File?, source: EasyImage.ImageSource?, type: Int) {
                this@HelpSendImageActivity.imageFile = imageFile
                chosenImage()
            }

            override fun onImagePickerError(e: Exception?, source: EasyImage.ImageSource?, type: Int) {
                //TODO Some error handling
            }
        })
    }

    fun chosenImage() {
        loadImage()
        chooseAppToSendImage_button.visibility = View.VISIBLE

        animateTextChange()
    }

    fun loadImage() {
        Glide.with(this)
                .load(imageFile)
                .into(photoFromGallery_imageView)
    }

    fun animateTextChange() {
        var animator = createButtonTextChangeAnimator(Color.WHITE, Color.TRANSPARENT)
        animator.start()
        animator.addListener(object : Animator.AnimatorListener {

            override fun onAnimationRepeat(animation: Animator?) {}

            override fun onAnimationEnd(animation: Animator?) {
                chooseImage_button.text = getString(R.string.choose_image_to_send_change)
                createButtonTextChangeAnimator(Color.TRANSPARENT, Color.WHITE).start()
            }

            override fun onAnimationCancel(animation: Animator?) {}

            override fun onAnimationStart(animation: Animator?) {}
        })
    }

    fun createButtonTextChangeAnimator(sourceColor: Int, destColor: Int): ObjectAnimator {
        var animator = ObjectAnimator.ofInt(chooseImage_button, "textColor", sourceColor, destColor)
        animator.duration = ANIMATION_SHORT_DURATION
        animator.setEvaluator(ArgbEvaluator())

        return animator
    }

    fun shareImage() {

        if (imageFile == null) {
            //TODO error

            return
        }

        startActivity(Intent.createChooser(createShareIntent(), getString(R.string.choose_app_to_send_image)))
    }

    fun createShareIntent(): Intent {
        var intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/jpeg"
        intent.putExtra(Intent.EXTRA_STREAM, imageFile)

        return intent
    }
}
