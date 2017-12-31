package eu.napcode.android_for_dummies.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.getHelpEntries
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = getLayoutManager()
        recyclerView.adapter = MainAdapter(this, getHelpEntries(this)) {
            startActivity(it.activityIntent)
        }
    }

    private fun getLayoutManager() : LinearLayoutManager {
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        return layoutManager
    }
}
