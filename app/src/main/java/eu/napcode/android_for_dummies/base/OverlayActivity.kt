package eu.napcode.android_for_dummies.base

import android.app.Activity
import android.graphics.RectF
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.napcode.android_for_dummies.R
import kotlinx.android.synthetic.main.activity_overlay.*

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overlay)

        setupImageView()

        bottomTextView.setText(getText())
    }

    fun setupImageView() {
        overlayImageView.setOnClickListener({
            setResult(Activity.RESULT_OK)
            finish()
        })


        overlayImageView.setCircle(getRectF(), getRadius())
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