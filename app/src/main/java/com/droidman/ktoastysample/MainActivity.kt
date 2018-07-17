package com.droidman.ktoastysample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.droidman.ktoasty.KToasty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener(clickListener)
        button2.setOnClickListener(clickListener)
        button3.setOnClickListener(clickListener)
        button4.setOnClickListener(clickListener)
        button5.setOnClickListener(clickListener)
        button6.setOnClickListener(clickListener)
        button7.setOnClickListener(clickListener)
        button8.setOnClickListener(clickListener)
    }

    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        when(view.id) {
            R.id.button1 -> {
                KToasty.error(this, "This is an error toast", Toast.LENGTH_SHORT, true).show()
            }
            R.id.button2 -> {
                KToasty.success(this, "This is a success toast", Toast.LENGTH_SHORT, true).show()
            }
            R.id.button3 -> {
                KToasty.info(this, "This is an info toast", Toast.LENGTH_SHORT, true).show()
            }
            R.id.button4 -> {
                KToasty.warning(this, "This is a warning toast", Toast.LENGTH_SHORT, true).show()
            }
            R.id.button5 -> {
                KToasty.normal(this, "This is a normal toast without icon").show()
            }
            R.id.button6 -> {
                KToasty.normal(this, "This is a normal toast with icon", getDrawable(R.drawable.android_logo)).show()
            }
            R.id.button7 -> {

            }
            R.id.button8 -> {

            }
        }
    }
}
