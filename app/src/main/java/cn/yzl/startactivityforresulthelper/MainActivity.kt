package cn.yzl.startactivityforresulthelper

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import cn.yzl.startactivityforesult.library.startActivityForResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt.setOnClickListener {
            this@MainActivity.startActivityForResult(Intent(this@MainActivity, MainActivity::class.java),
                    1000) {
                Log.e("AAA", it.resultCode.toString())
            }
        }
    }

    override fun onBackPressed() {
        setResult(1000)
        super.onBackPressed()
    }
}
