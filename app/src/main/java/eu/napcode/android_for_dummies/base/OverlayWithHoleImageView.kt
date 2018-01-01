package eu.napcode.android_for_dummies.base

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.support.v7.widget.AppCompatImageView

class OverlayWithHoleImageView(context: Context, attrs: AttributeSet) : AppCompatImageView(context, attrs) {

    private var circleRect: RectF? = null
    private var radius: Int = 0

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    fun setCircle(rect: RectF, radius: Int) {
        this.circleRect = rect
        this.radius = radius
        //Redraw after defining circle
        postInvalidate()
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (circleRect != null) {
            val paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint.color = resources.getColor(android.R.color.black)
            paint.style = Paint.Style.FILL
            canvas.drawPaint(paint)

            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            canvas.drawRoundRect(circleRect!!, radius.toFloat(), radius.toFloat(), paint)
        }
    }
}