package eu.napcode.android_for_dummies.base

import android.graphics.RectF
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class OverlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var overlayImageView = OverlayWithHoleImageView(this)
        setContentView(overlayImageView)
        overlayImageView.setCircle(RectF(100f, 100f, 200f, 200f), 50)
    }
}