package com.example.exoplanets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SpScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent= Intent(this@SpScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}