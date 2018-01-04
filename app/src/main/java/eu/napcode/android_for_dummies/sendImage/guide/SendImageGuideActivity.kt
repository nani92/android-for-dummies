package eu.napcode.android_for_dummies.sendImage.guide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import eu.napcode.android_for_dummies.R
import kotlinx.android.synthetic.main.activity_send_image_guide.*

class SendImageGuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_image_guide)

        setSupportActionBar(toolbar)
        supportActionBar!!.show()
        stepperLayout.adapter = SendImageGuideStepperAdapter(supportFragmentManager, this)
    }

    fun displayTitle(titleId: Int) {
        supportActionBar!!.title = getString(titleId)
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