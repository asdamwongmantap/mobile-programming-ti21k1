package com.example.intenpindahwithdata

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivityWithData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_with_data)
        val textView: TextView = findViewById(R.id.textViewWithData)
        if (intent.hasExtra("name_part")){
            textView.text = intent.getStringExtra("name_part")
        }else{
            Toast.makeText(applicationContext,"Tidak Ada Data", Toast.LENGTH_SHORT).show()
        }
    }
}