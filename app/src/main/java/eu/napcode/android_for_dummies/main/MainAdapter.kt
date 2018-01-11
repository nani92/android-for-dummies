package eu.napcode.android_for_dummies.main

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import eu.napcode.android_for_dummies.base.HelpEntry
import eu.napcode.android_for_dummies.R

class MainAdapter(var context: Context, var helpEntries: ArrayList<HelpEntry>, val listener: (HelpEntry) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun getItemCount(): Int = helpEntries.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(helpEntries[position], listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent.inflate(R.layout.view_item))

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(helpEntry: HelpEntry, listener: (HelpEntry) -> Unit) {
            itemView.findViewById<TextView>(R.id.help_name_text_view).setText(helpEntry.nameResourceId)
            itemView.findViewById<ImageView>(R.id.help_image_view).setImageDrawable(context.getDrawable(helpEntry.imageResourceId))

            itemView.setOnClickListener { listener(helpEntry) }
        }
    }
}
