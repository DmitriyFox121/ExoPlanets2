package com.example.exoplanets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView

class ProgramActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program)

        textView=findViewById(R.id.oProgramme)
        val text: String=" "
        textView.text=text
        textView.movementMethod= ScrollingMovementMethod()

    }
}