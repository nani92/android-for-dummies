package eu.napcode.android_for_dummies.about

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_about_dev.*
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.text.Html
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.transition.Fade
import eu.napcode.android_for_dummies.R
import eu.napcode.android_for_dummies.base.ANIMATION_STANDARD_DURATION

class AboutDevActivity : AppCompatActivity() {

    var EMAIL_ACTION_TYPE = "text/plain"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_dev)

        window.enterTransition = Fade().setDuration(ANIMATION_STANDARD_DURATION)

        setupNapCode()
        setupAuthor()
        setupPlayStore()
        setupGithub()
        setupMail()
        setupIcons()
    }

    fun setupNapCode() {
        logoImageView.setOnClickListener(onNapCodeClickListener)
        nameImageView.setOnClickListener(onNapCodeClickListener)
    }

    var onNapCodeClickListener: View.OnClickListener = View.OnClickListener {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(NAPCODE_URL)
        startActivity(intent)
    }

    fun setupAuthor() {
        //TODO needs refactor
        val author = getAuthorString()
        var spannable = SpannableString(author)

        var appNameStart = 0
        var appNameEnd = getByStartPosition(author)
        spannable.setSpan(StyleSpan(Typeface.BOLD), appNameStart, appNameEnd, 0)
        spannable.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPrimaryDark)),
                appNameStart, appNameEnd, 0)

        var napcodeStart = getAtStartPosition(author)
        var napcodeEnd = author.length

        spannable.setSpan(StyleSpan(Typeface.BOLD), napcodeStart, napcodeEnd, 0)
        spannable.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPrimary)),
                napcodeStart, napcodeEnd, 0)

        authorTextView.setText(spannable)
    }

    fun getAuthorString(): String {
        return getString(R.string.author,
                getString(R.string.app_name),
                getString(R.string.by))
    }

    fun getByStartPosition(author: String): Int {
        return author.indexOf(getString(R.string.by))
    }

    fun getAtStartPosition(author: String): Int {
        return author.indexOf("@")
    }

    fun setupPlayStore() {
        playStoreImageView.setOnClickListener({
            var uri = Uri.parse(NAPCODE_PLAY_STORE_URL)
            var intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        })
    }

    fun setupGithub() {
        githubImageView.setOnClickListener({
            var uri = Uri.parse(NANI_GITHUB_URL)
            var intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        })
    }

    fun setupMail() {
        mailImageView.setOnClickListener({

            try {
                trySendEmailWithSendTo()
            } catch (e: ActivityNotFoundException) {
                Snackbar
                        .make(scrollView, getString(R.string.email_error), Snackbar.LENGTH_SHORT)
                        .show()
            }
        })
    }

    @Throws(ActivityNotFoundException::class)
    fun trySendEmailWithSendTo(){
        var emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = EMAIL_ACTION_TYPE
        emailIntent.putExtra(Intent.EXTRA_EMAIL, NANI_EMAIL)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))

        startActivity(emailIntent)
    }

    fun setupIcons() {
        iconsTextView.isClickable = true
        iconsTextView.movementMethod = LinkMovementMethod.getInstance()

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            iconsTextView.setText(Html.fromHtml(getIconsHtmlString()))
        } else {
            iconsTextView.setText(Html.fromHtml(getIconsHtmlString(), Html.FROM_HTML_MODE_COMPACT));
        }
    }

    fun getIconsHtmlString(): String {
        var stringBuilder = StringBuilder("<ul>")
        stringBuilder.append("<li>")
                .append(ICON_CREDITS_THOSE_ICONS)
                .append("</li><br><li>")
                .append(ICON_CREDITS_CURSOR_CREATIVE)
                .append("</li><br><li>")
                .append(ICON_CREDITS_SMASHICONS)
                .append("</li><br><li>")
                .append(ICON_CREDITS_FREEPIK)
                .append("</li><br><li>")
                .append(ICON_CREDITS_GOOGLE)
                .append("</li><br><li>")
                .append(ICON_CREDITS_STEPHEN)
                .append("</li></ul>")

        return stringBuilder.toString()
    }
}