package com.example.mysecondnotes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mysecondnotes.data.NoteDB
import com.example.mysecondnotes.data.entity.Note

class InputActivity : AppCompatActivity() {
    private lateinit var title: EditText
    private lateinit var noteField: EditText
    private lateinit var btnSave: Button
    private lateinit var database: NoteDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input)
        title = findViewById(R.id.edit_title)
        noteField = findViewById(R.id.edit_note)
        btnSave = findViewById(R.id.button_save)

        database = NoteDB.getInstance(applicationContext)

        btnSave.setOnClickListener {
            if (title.text.isNotEmpty() && noteField.text.isNotEmpty()) {
                database.noteDao().insertAll(
                    Note(
                        null,
                        title.text.toString(),
                        noteField.text.toString()
                    )
                )
                finish()
            } else {
                Toast.makeText(applicationContext, "Silahkan isi semua data", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}