package eu.napcode.android_for_dummies.base

import android.content.Context
import android.view.Gravity
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import eu.napcode.android_for_dummies.R

fun getCustomToast(context: Context, messageResource: Int) : Toast {
    return getCustomToast(context, context.getString(messageResource))
}

fun getCustomToast(context: Context, message: String) : Toast{
    val toast = Toast(context)
    toast.duration = Toast.LENGTH_LONG
    toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL, 0, 0)
    toast.view = getCustomToastLayout(context, message)

    return toast
}

private fun getCustomToastLayout(context: Context, message: String): View {
    var layoutInflater = LayoutInflater.from(context)
    val layout = layoutInflater.inflate(R.layout.toast, null)
    layout.findViewById<TextView>(R.id.text).text = message

    return layout
}