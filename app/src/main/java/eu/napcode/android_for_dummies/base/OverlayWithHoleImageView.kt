package eu.napcode.android_for_dummies.base

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.support.v4.content.ContextCompat
import android.view.View
import android.support.v7.widget.AppCompatImageView
import eu.napcode.android_for_dummies.R

class OverlayWithHoleImageView(context: Context) : AppCompatImageView(context) {

    private var circleRect: RectF? = null
    private var radius: Int = 0

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    fun setCircle(rect: RectF, radius: Int) {
        this.circleRect = rect
        this.radius = radius

        postInvalidate()
    }

    fun setRightCorner(width: Int) {
        this.radius = 600
        this.circleRect = RectF(width.toFloat() - radius / 2, -radius / 2f, width.toFloat() * 2, radius.toFloat())

        postInvalidate()
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (circleRect != null) {
            val paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint.color = ContextCompat.getColor(context, R.color.colorAccentTransparent)
            paint.style = Paint.Style.FILL
            canvas.drawPaint(paint)

            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            canvas.drawRoundRect(circleRect!!, radius.toFloat(), radius.toFloat(), paint)
        }
    }
}