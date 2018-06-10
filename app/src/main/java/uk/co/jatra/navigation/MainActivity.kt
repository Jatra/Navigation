package uk.co.jatra.navigation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*

const val REQUEST_CODE = 101

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondLevelActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        result.text = resultCode.toString()
        result.visibility = if (requestCode == REQUEST_CODE) VISIBLE else GONE
    }
}
