package eu.napcode.android_for_dummies.base

import android.animation.ObjectAnimator
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.design.widget.AppBarLayout
import android.transition.TransitionManager
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import eu.napcode.android_for_dummies.R
import kotlinx.android.synthetic.main.help_entry_main_toolbar.*
import kotlinx.android.synthetic.main.help_entry_main_toolbar.view.*
import org.w3c.dom.Text

class CollapsibleToolbarConstraintLayout : ConstraintLayout, AppBarLayout.OnOffsetChangedListener {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributes: AttributeSet?) : this(context, attributes, 0)
    constructor(context: Context, attributes: AttributeSet?, defStyleAttr: Int) : super(context, attributes, defStyleAttr)

    var closingTransitionTreshold = 0.35f
    var openingTransitionTreshold = 0.1f
    var lastPosition = 0
    var isToolbarOpen = true

    var openToolbar = ConstraintSet()
    val closedToolbar = ConstraintSet()

    var title: TextView? = null
    var transitionTitle: AnimationHelper? = null
    var icon: ImageView? = null
    var transitionIcon: AnimationHelper? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        if (parent is AppBarLayout) {
            var appBarLayout = parent as AppBarLayout
            appBarLayout.addOnOffsetChangedListener(this)
            openToolbar.clone(context, R.layout.help_entry_main_toolbar_opened)
            closedToolbar.clone(context, R.layout.help_entry_main_toolbar_closed)
        }

        title = helpEntryToolbarTitle_textView
        icon = imageView
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        Log.d("Natalia", "offset changed")
        Log.d("Natalia", "verticalo " + verticalOffset)

        if (lastPosition == verticalOffset) {
            return
        }

        lastPosition = verticalOffset

//        if (appBarLayout?.height == 0) {
//            return
//        }

        var progress = Math.abs(verticalOffset / appBarLayout?.height?.toFloat()!!)

        var params = layoutParams as AppBarLayout.LayoutParams
        params.topMargin = -verticalOffset
        layoutParams = params

        Log.d("Natalia", "progress " + progress + " vert " + verticalOffset + " h " + appBarLayout?.height)

        if (isToolbarOpen && progress > closingTransitionTreshold) {
            Log.d("Natalia", "closing")
            closedToolbar.applyTo(this)
            isToolbarOpen = false}
//        } else if (isToolbarOpen == false && progress < closingTransitionTreshold && progress > 0) {
//            Log.d("Natalia", "opening")
//            openToolbar.applyTo(this)
//            isToolbarOpen = true
//        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        if (title != null && transitionTitle == null) {
            transitionTitle = AnimationHelper(title!!)
        }

        if (icon != null && transitionIcon == null) {
            transitionIcon = AnimationHelper(icon!!)
        }

        transitionTitle?.evaluate()
        transitionIcon?.evaluate()
    }
}

class AnimationHelper(view: View) {
    var initialValue = 0
    var target = view

    init {
        initialValue = target.left
    }

    fun evaluate() {

        if (initialValue != target.left) {
            var delta = (initialValue - target.left).toFloat()
            var animation = ObjectAnimator.ofFloat(target, "translationX", delta, 0f)
            animation.duration = ANIMATION_SHORT_DURATION
            animation.start()

            initialValue = target.left
        }
    }
}
