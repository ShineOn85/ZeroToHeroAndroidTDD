package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.titleTextView);
        val button = findViewById<Button>(R.id.changeButton)
        button.setOnClickListener{
            textView.text = "I am an Android Developer!"
        }
    }



}