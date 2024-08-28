package com.example.mysecondnotes.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mysecondnotes.data.entity.Note

@Dao
interface NoteDao {
    @Insert
    fun insertAll(vararg note: Note)


    @Query("SELECT * FROM note")
    fun getAll(): List<Note>
}