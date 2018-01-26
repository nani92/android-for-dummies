package eu.napcode.android_for_dummies.about

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.ANIMATION_STANDARD_DURATION
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        window.enterTransition = Fade().setDuration(ANIMATION_STANDARD_DURATION)

        setupAppIdeaSection()
        setupGithubButton()
    }

    fun setupAppIdeaSection() {
        setupAboutAppTextView()
        setupSendMailButton()
    }

    fun setupAboutAppTextView() {
        about_textView.setText(R.string.about_app)
        about_textView.append("\n\n")
        about_textView.append(getString(R.string.about_app_2))
        about_textView.append("\n\n")
        about_textView.append(getString(R.string.about_app_3))
        about_textView.append("\n\n")
        about_textView.append(getString(R.string.about_app_4))
    }

    fun setupSendMailButton() {
        sendMail_button.setOnClickListener({

            try {
                startActivity(getEmailIntent(this))
            } catch (e: ActivityNotFoundException) {
                Snackbar
                        .make(scrollView, getString(R.string.email_error), Snackbar.LENGTH_SHORT)
                        .show()
            }
        })
    }

    fun setupGithubButton() {
        github_button.setOnClickListener({
            var uri = Uri.parse(ANDROID_FOR_DUMMIES_GITHUB_URL)
            var intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        })
    }
}
