package com.example.k007myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val aboutUsButton = findViewById<Button>(R.id.button2)
        aboutUsButton.setOnClickListener {
            val intent = Intent(this, about_us::class.java)
            startActivity(intent)
        }
        val contactUsButton = findViewById<Button>(R.id.button3)
        contactUsButton.setOnClickListener {
            val intent2 = Intent(this, ContactUs::class.java)
            startActivity(intent2)
        }
        val galleryButton = findViewById<Button>(R.id.galleryButton)
        galleryButton.setOnClickListener {
            val intent3 = Intent(this, Gallery::class.java)
            startActivity(intent3)
        }
        val dailyTipButton = findViewById<Button>(R.id.dailyTipButton)
        dailyTipButton.setOnClickListener {
            val intent4 = Intent(this, DailyTipActivity::class.java)
            startActivity(intent4)
        }
    }
}