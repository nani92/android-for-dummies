package eu.napcode.android_for_dummies.main

import android.app.ActivityOptions
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.LinearLayoutManager
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.getHelpEntries
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = getLayoutManager()
        recyclerView.adapter = MainAdapter(this, getHelpEntries(this)) {
            startActivity(it.activityIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }

    private fun getLayoutManager() : LinearLayoutManager {
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        return layoutManager
    }
}
