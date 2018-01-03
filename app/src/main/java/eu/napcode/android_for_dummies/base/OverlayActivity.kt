package eu.napcode.android_for_dummies.base

import android.graphics.RectF
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.Log

public var SHOW_VIEW_ELEMENT_LEFT_KEY = "left"
public var SHOW_VIEW_ELEMENT_TOP_KEY = "top"
public var SHOW_VIEW_ELEMENT_RIGHT_KEY = "right"
public var SHOW_VIEW_ELEMENT_BOTTOM_KEY = "bottom"
public var SHOW_VIEW_ELEMENT_RADIUS = "radius"

public var SHOW_VIEW_ELEMENT_BUNDLE = "bundle"

public var SHOW_VIEW_RIGHT_CORNER = "corner"

class OverlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var overlayImageView = OverlayWithHoleImageView(this)
        setContentView(overlayImageView)

        if (intent.getBundleExtra(SHOW_VIEW_ELEMENT_BUNDLE).getBoolean(SHOW_VIEW_RIGHT_CORNER, false)) {
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