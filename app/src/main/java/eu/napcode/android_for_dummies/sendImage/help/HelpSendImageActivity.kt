package eu.napcode.android_for_dummies.sendImage.help

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.napcode.android_for_dummies.R
import pl.aprilapps.easyphotopicker.EasyImage
import pl.aprilapps.easyphotopicker.DefaultCallback
import android.content.Intent
import android.graphics.Color
import android.support.design.widget.Snackbar
import android.support.v4.content.FileProvider
import android.transition.Slide
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import eu.napcode.android_for_dummies.base.ANIMATION_SHORT_DURATION
import kotlinx.android.synthetic.main.activity_help_send_image.*
import java.io.File

class HelpSendImageActivity : AppCompatActivity() {

    var imageFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_send_image)

        window.enterTransition = Slide().setDuration(ANIMATION_SHORT_DURATION)

        chooseImage_button.setOnClickListener({ EasyImage.openGallery(this, 0) })
        chooseAppToSendImage_button.setOnClickListener({ shareImage() })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_CANCELED) {
            return
        }

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, object : DefaultCallback() {
            override fun onImagePicked(imageFile: File?, source: EasyImage.ImageSource?, type: Int) {
                this@HelpSendImageActivity.imageFile = imageFile
                chosenImage()
            }

            override fun onImagePickerError(e: Exception?, source: EasyImage.ImageSource?, type: Int) {
                Snackbar.make(container_ConstraintLayout, R.string.pick_image_error, Snackbar.LENGTH_SHORT).show()
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
                .transition(withCrossFade())
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
            Snackbar.make(container_ConstraintLayout,
                    R.string.share_image_error,
                    Snackbar.LENGTH_SHORT).show()

            return
        }

        startActivity(Intent.createChooser(createShareIntent(), getString(R.string.choose_app_to_send_image)))
    }

    fun createShareIntent(): Intent {
        var fileProviderAuthority = "eu.napcode.android_for_dummies.easyphotopicker.fileprovider"
        var intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/jpeg"
        intent.putExtra(Intent.EXTRA_STREAM,
                FileProvider.getUriForFile(this,
                        fileProviderAuthority,
                        imageFile!!))
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        return intent
    }
}
