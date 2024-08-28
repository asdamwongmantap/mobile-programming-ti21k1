package com.example.mysecondnotes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true) var id:Int? = null,
    @ColumnInfo(name = "title") var title:String?,
    @ColumnInfo(name = "note") var note:String?
)