package eu.napcode.android_for_dummies.sendImage.guide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import eu.napcode.android_for_dummies.R
import kotlinx.android.synthetic.main.activity_send_image_guide.*

class SendImageGuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_image_guide)

        stepperLayout.adapter = SendImageGuideStepperAdapter(supportFragmentManager, this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.image_preview_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        super.onPrepareOptionsMenu(menu)
        openOptionsMenu()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return false
    }

    fun displayTitle(titleId: Int) {
        supportActionBar!!.title = getString(titleId)
        openOptionsMenu()
        openOptionsMenu()
    }

    fun showMenu() {

        openOptionsMenu()
        //if (supportActionBar != null)
        //supportActionBar!!.openOptionsMenu()
    }

    override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
        return super.onMenuOpened(featureId, menu)
    }
}