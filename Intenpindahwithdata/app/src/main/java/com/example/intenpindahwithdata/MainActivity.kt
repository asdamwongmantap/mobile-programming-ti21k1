package com.example.intenpindahwithdata

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btn_explisit : Button
    private lateinit var btn_explisit_withdata : Button
    private lateinit var btn_implicit : Button
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        //button explisit wo data
        btn_explisit = findViewById(R.id.btn_explisit)
        btn_explisit.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        //button explisit with data
        btn_explisit_withdata = findViewById(R.id.btn_explisit_withdata)
        btn_explisit_withdata.setOnClickListener {
            val intent = Intent(this,SecondActivityWithData::class.java)
            intent.putExtra("name_part","Second Activity Lagi")
            startActivity(intent)
        }
        //button implicit intent
        btn_implicit = findViewById(R.id.btn_implicit)
        btn_implicit.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://wongmantap.com"))
            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Tidak Ada Aplikasi yang Support", Toast.LENGTH_SHORT).show()
            }

        }
    }
}