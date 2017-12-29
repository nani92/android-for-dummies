package eu.napcode.android_for_dummies

import android.content.Context
import android.content.Intent

/**HelpEntry is a basic object that will be displayed on main screen**/
class HelpEntry(var nameResourceId: Int, var imageResourceId: Int, var activityIntent: Intent)

fun getHelpEntries(context: Context): List<HelpEntry> {
    val helpEntries : ArrayList<HelpEntry> = ArrayList();

    helpEntries.add(HelpEntry(R.string.send_image_help_entry_name, R.mipmap.ic_launcher, Intent(context, MainActivity::class.java)))

    return helpEntries
}