package com.example.mysecondnotes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mysecondnotes.data.dao.NoteDao
import com.example.mysecondnotes.data.entity.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDB: RoomDatabase(){
    abstract fun noteDao(): NoteDao

    companion object {
        private var instance:NoteDB? = null

        fun getInstance(context: Context): NoteDB{
            if (instance==null){
                instance = Room.databaseBuilder(context,NoteDB::class.java,"app-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instance!!
        }
    }
}