package eu.napcode.android_for_dummies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainActivity::class.java

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = getLayoutManager()
    }

    private fun getLayoutManager() : LinearLayoutManager {
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        return layoutManager
    }
}
