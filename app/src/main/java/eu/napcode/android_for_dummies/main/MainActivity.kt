package eu.napcode.android_for_dummies.main

import android.app.ActivityOptions
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.LinearLayoutManager
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.getHelpEntries
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.AppCompatImageView
import android.util.Pair
import android.view.View
import android.widget.TextView
import eu.napcode.android_for_dummies.base.HelpEntry


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = getLayoutManager()
        recyclerView.adapter = MainAdapter(this, getHelpEntries(this), object : OnItemClickListener {
            override fun onItemClick(helpEntry: HelpEntry, view: View) {
                val transitionActivityOptions = ActivityOptions
                        .makeSceneTransitionAnimation(this@MainActivity,
                                Pair<View, String>(view.findViewById<AppCompatImageView>(R.id.help_image_view), getString(R.string.help_entry_image_view_transition_name)),
                                Pair<View, String>(view.findViewById<TextView>(R.id.help_name_text_view), getString(R.string.help_entry_title_text_view_transition_name)))
                startActivity(helpEntry.activityIntent, transitionActivityOptions.toBundle())
            }
        })
    }

    private fun getLayoutManager(): LinearLayoutManager {
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        return layoutManager
    }
}
