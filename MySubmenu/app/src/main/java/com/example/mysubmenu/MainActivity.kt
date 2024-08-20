package com.example.mysubmenu

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // for changing the background color of title bar
        val aBar = supportActionBar
        val cd = ColorDrawable(Color.parseColor("#FF00FF00"))
        aBar?.setBackgroundDrawable(cd)
    }
    // using inflater for menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
}