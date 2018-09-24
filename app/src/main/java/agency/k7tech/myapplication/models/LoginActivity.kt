package agency.k7tech.myapplication.models

import agency.k7tech.myapplication.BaseActivity
import agency.k7tech.myapplication.R
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Window
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.indeterminateProgressDialog

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            val dialog = indeterminateProgressDialog("This a progress dialog")
            Handler().postDelayed({
                dialog.dismiss()
                val options = ActivityOptions.makeSceneTransitionAnimation(this, logo, "logo")
                startActivity(Intent(this, BaseActivity::class.java), options.toBundle())
                finishAfterTransition()
            }, 1000)
        }


    }
}
