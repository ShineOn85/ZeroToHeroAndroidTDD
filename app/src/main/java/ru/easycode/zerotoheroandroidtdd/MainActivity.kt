package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.incrementButton)
        textView = findViewById(R.id.countTextView)
        textView.text = number.toString()
        button.setOnClickListener {
            number += 2
            textView.text = number.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("key", number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState.getInt("key").toString()
        number = savedInstanceState.getInt("key")
    }
}
