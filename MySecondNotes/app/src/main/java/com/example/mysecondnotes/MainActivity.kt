package com.example.mysecondnotes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.mysecondnotes.adapter.NoteAdapter
import com.example.mysecondnotes.data.NoteDB
import com.example.mysecondnotes.data.entity.Note

class MainActivity : AppCompatActivity() {
    lateinit var button_create: Button
    private var list = mutableListOf<Note>()
    private lateinit var adapter: NoteAdapter
    private lateinit var database:NoteDB
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        button_create = findViewById(R.id.button_create)
        recyclerView = findViewById(R.id.recyler_view)

        database = NoteDB.getInstance(applicationContext)
        adapter = NoteAdapter(list)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, VERTICAL,false)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL))

        loadForm()
    }

    fun loadForm(){
        button_create.setOnClickListener{
            startActivity(Intent(this,InputActivity::class.java))
        }
    }



    override fun onResume() {
        super.onResume()
        getData()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getData(){
        list.clear()
        list.addAll(database.noteDao().getAll())
        adapter.notifyDataSetChanged()
    }
}