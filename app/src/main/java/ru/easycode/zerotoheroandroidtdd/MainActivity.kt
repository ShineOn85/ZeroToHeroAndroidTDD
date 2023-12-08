package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private var state: State = State.Initial

    private lateinit var layout: LinearLayout
    private lateinit var textView: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout = findViewById(R.id.rootLayout)
        textView = findViewById<TextView>(R.id.titleTextView)
        button = findViewById<Button>(R.id.removeButton)
        button.setOnClickListener {
            state = State.Removed
            state.apply(layout,button,textView)
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("key",state)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val state = savedInstanceState.getSerializable("key") as State
        state.apply(layout, button, textView)
    }
}

interface State : Serializable {
    fun apply(layout: LinearLayout, button: Button, textView: TextView)

    object Initial : State{
        override fun apply(layout: LinearLayout, button: Button, textView: TextView) = Unit
    }
    object Removed : State{
        override fun apply(layout: LinearLayout, button: Button, textView: TextView) {
            layout.removeView(textView)
            button.isEnabled = false
        }

    }

}