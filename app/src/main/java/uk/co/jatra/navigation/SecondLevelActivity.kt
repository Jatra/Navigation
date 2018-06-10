package uk.co.jatra.navigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.second.*

class SecondLevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button1.setOnClickListener {
            finish(17)
        }
        button2.setOnClickListener {
            finish(42)
        }
    }
    private fun finish(result: Int) {
        setResult(result)
        finish()
    }
}
