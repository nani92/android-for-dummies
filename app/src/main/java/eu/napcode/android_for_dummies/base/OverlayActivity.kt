package eu.napcode.android_for_dummies.base

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.app.Activity
import android.graphics.RectF
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.napcode.android_for_dummies.R
import kotlinx.android.synthetic.main.activity_overlay.*
import android.animation.ObjectAnimator
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.TextView

public var DISPLAY_TEXT_TOP = 0
public var DISPLAY_TEXT_BOTTOM = 1

var SHOW_VIEW_ELEMENT_LEFT_KEY = "left"
var SHOW_VIEW_ELEMENT_TOP_KEY = "top"
var SHOW_VIEW_ELEMENT_RIGHT_KEY = "right"
var SHOW_VIEW_ELEMENT_BOTTOM_KEY = "bottom"
var SHOW_VIEW_ELEMENT_RADIUS_KEY = "radius"

var DISPLAY_TEXT_PLACE_KEY = "place for text"
var DISPLAY_TEXT_VALUE_KEY = "text"

class OverlayActivity : AppCompatActivity() {

    var DEFAULT_RADIUS = 30
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overlay)

        setupImageView()
        setupTextView()

        setupAnimations()
    }

    fun setupImageView() {
        overlay_imageView.visibility = View.GONE
        overlay_imageView.setOnClickListener({
            setResult(Activity.RESULT_OK)
            finish()
        })

        overlay_imageView.setCircle(getRectF(), getRadius())
    }

    fun setupTextView() {
        textView = bottom_textView
        textView.text = getText()
        textView.visibility = View.GONE
    }

    fun setupAnimations() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        val imageViewAnimation = ObjectAnimator.ofFloat(overlay_imageView, "alpha", 0f, 1f)
        imageViewAnimation.duration = ANIMATION_SHORT_DURATION
        makeViewVisibleOnAnimationStart(imageViewAnimation, overlay_imageView)
        imageViewAnimation.startDelay = ANIMATION_SHORT_DELAY

        val textViewAnimation = ObjectAnimator.ofFloat(textView, "translationY", displayMetrics.heightPixels / 3f, textView.translationY)
        textViewAnimation.duration = ANIMATION_STANDARD_DURATION
        makeViewVisibleOnAnimationStart(textViewAnimation, textView)
        textViewAnimation.interpolator = AccelerateDecelerateInterpolator()

        var animatorSet = AnimatorSet()
        animatorSet.play(textViewAnimation).after(imageViewAnimation)
        animatorSet.start()
    }

    fun makeViewVisibleOnAnimationStart(objectAnimator: ObjectAnimator, view: View) {
        objectAnimator.addListener(object : AnimatorListenerAdapter() {

            override fun onAnimationStart(animation: Animator?) {
                super.onAnimationStart(animation)
                view.visibility = View.VISIBLE
            }
        })
    }

    fun getRectF(): RectF {
        return RectF(intent.getIntExtra(SHOW_VIEW_ELEMENT_LEFT_KEY, 0).toFloat(),
                intent.getIntExtra(SHOW_VIEW_ELEMENT_TOP_KEY, 0).toFloat(),
                intent.getIntExtra(SHOW_VIEW_ELEMENT_RIGHT_KEY, 0).toFloat(),
                intent.getIntExtra(SHOW_VIEW_ELEMENT_BOTTOM_KEY, 0).toFloat())
    }

    fun getRadius(): Int {
        return intent.getIntExtra(SHOW_VIEW_ELEMENT_RADIUS_KEY, DEFAULT_RADIUS)
    }

    fun getText(): String {
        return intent.getStringExtra(DISPLAY_TEXT_VALUE_KEY)
    }
}