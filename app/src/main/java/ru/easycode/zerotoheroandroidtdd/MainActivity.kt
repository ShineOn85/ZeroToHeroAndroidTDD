package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var isGone = false
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.hideButton)
        textView = findViewById(R.id.titleTextView)
        button.setOnClickListener{
            textView.visibility = View.GONE
            isGone = true
        }
        savedInstanceState?.let {
            isGone = savedInstanceState.getBoolean("isGone")
            if (isGone)
                textView.visibility = View.GONE
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isGone", isGone)
    }
}