package com.example.growigh_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class intro2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro2)

        val skip1 = findViewById<TextView>(R.id.skip3)
        skip1.setOnClickListener {
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent)
        }
        val progress2 = findViewById<TextView>(R.id.progress2)
        progress2.setOnClickListener {
            val intent = Intent(this, intro3::class.java)
            startActivity(intent)
        }
    }
}