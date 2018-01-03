package eu.napcode.android_for_dummies.base

import android.app.Activity
import android.graphics.RectF
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics

var SHOW_VIEW_ELEMENT_LEFT_KEY = "left"
var SHOW_VIEW_ELEMENT_TOP_KEY = "top"
var SHOW_VIEW_ELEMENT_RIGHT_KEY = "right"
var SHOW_VIEW_ELEMENT_BOTTOM_KEY = "bottom"
var SHOW_VIEW_ELEMENT_RADIUS = "radius"

var SHOW_VIEW_RIGHT_CORNER = "corner"

class OverlayActivity : AppCompatActivity() {

    lateinit var overlayImageView: OverlayWithHoleImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupImageView()
        handleIntent()
    }

    fun setupImageView() {
        overlayImageView = OverlayWithHoleImageView(this)

        overlayImageView.setOnClickListener({
            setResult(Activity.RESULT_OK)
            finish()
        })

        setContentView(overlayImageView)
    }

    fun handleIntent() {
        if (intent.getBooleanExtra(SHOW_VIEW_RIGHT_CORNER, false)) {
            var displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            overlayImageView.setRightCorner(displayMetrics.widthPixels)
        } else {
            overlayImageView.setCircle(getRectF(),
                    intent.getIntExtra(SHOW_VIEW_ELEMENT_RADIUS, 0))
        }
    }

    fun getRectF(): RectF {
        return RectF(intent.getFloatExtra(SHOW_VIEW_ELEMENT_LEFT_KEY, 0f),
                intent.getFloatExtra(SHOW_VIEW_ELEMENT_TOP_KEY, 0f),
                intent.getFloatExtra(SHOW_VIEW_ELEMENT_RIGHT_KEY, 0f),
                intent.getFloatExtra(SHOW_VIEW_ELEMENT_BOTTOM_KEY, 0f))
    }
}