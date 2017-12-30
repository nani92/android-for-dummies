package eu.napcode.android_for_dummies.base

import android.content.Context
import android.content.Intent
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.sendImage.SendImageMainActivity

/**HelpEntry is a basic object representing action that we want to guide our user**/
class HelpEntry(var nameResourceId: Int, var imageResourceId: Int, var activityIntent: Intent)

fun getHelpEntries(context: Context): ArrayList<HelpEntry> {
    val helpEntries : ArrayList<HelpEntry> = ArrayList()

    helpEntries.add(HelpEntry(R.string.send_image_help_entry_name, R.mipmap.ic_launcher, Intent(context, SendImageMainActivity::class.java)))

    return helpEntries
}