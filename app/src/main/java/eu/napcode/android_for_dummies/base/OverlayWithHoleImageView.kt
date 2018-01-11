package eu.napcode.android_for_dummies.base

import android.content.Context
import android.graphics.*
import android.support.v4.content.ContextCompat
import android.view.View
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import eu.napcode.android_for_dummies.R

class OverlayWithHoleImageView: AppCompatImageView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

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

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (circleRect != null) {
            drawCircle(canvas)
        }
    }

    fun drawCircle(canvas: Canvas) {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = ContextCompat.getColor(context, R.color.colorAccentTransparent)
        paint.style = Paint.Style.FILL
        canvas.drawPaint(paint)

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        canvas.drawRoundRect(circleRect!!, radius.toFloat(), radius.toFloat(), paint)
    }
}