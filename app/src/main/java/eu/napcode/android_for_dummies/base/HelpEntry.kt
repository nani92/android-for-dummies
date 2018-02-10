package eu.napcode.android_for_dummies.base

import android.content.Context
import android.content.Intent
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.orientation.OrientationMainActivity
import eu.napcode.android_for_dummies.sendImage.SendImageMainActivity

/**HelpEntry is a basic object representing action that we want to guide our user**/
class HelpEntry(var nameResourceId: Int, var imageResourceId: Int, var activityIntent: Intent)

fun getHelpEntries(context: Context): ArrayList<HelpEntry> {
    val helpEntries : ArrayList<HelpEntry> = ArrayList()

    helpEntries.add(HelpEntry(R.string.send_image_help_entry_name, R.drawable.he_send_image, Intent(context, SendImageMainActivity::class.java)))
    helpEntries.add(HelpEntry(R.string.orientation_help_entry_name, R.drawable.he_orientation, Intent(context, OrientationMainActivity::class.java)))

    return helpEntries
}