package com.example.growigh_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class intro1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro1)

        val skip1 = findViewById<TextView>(R.id.skip3)
        skip1.setOnClickListener {
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent)
        }
        val progress1 = findViewById<TextView>(R.id.progress1)
        progress1.setOnClickListener {
            val intent = Intent(this, intro2::class.java)
            startActivity(intent)
        }
    }
}