package ru.easycode.zerotoheroandroidtdd

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ContentView
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    private lateinit var layout: LinearLayout
    private var isGone: Boolean = false
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout = findViewById(R.id.rootLayout)
        textView = findViewById<TextView>(R.id.titleTextView)
        val button = findViewById<Button>(R.id.removeButton)
        button.setOnClickListener{
           layout.removeView(textView)
            isGone = true
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
         outState.putBoolean("key", isGone)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val isGone = savedInstanceState.getBoolean("key")
        if (isGone)
            layout.removeView(textView)
    }
}