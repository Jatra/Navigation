package uk.co.jatra.navigation

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.second.*

class SecondLevelActivity : AppCompatActivity() {

    private lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button1.setOnClickListener { actionButton(it) }
        button2.setOnClickListener { actionButton(it) }

        application?.let {
            ViewModelFactory.instance(it)?.let {
                viewModel = ViewModelProviders.of(this, it).get(AppViewModel::class.java)
            }
        }
    }

    private fun actionButton(view: View) {
        viewModel.answer = (view.tag as String).toInt()
        finish()
    }
    /*
    Lots of stuff here that is specific to this activity...
     */
}
