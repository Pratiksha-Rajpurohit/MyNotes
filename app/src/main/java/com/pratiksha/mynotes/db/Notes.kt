package com.pratiksha.mynotes.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
data class Notes (

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val noteName : String,
    val noteContent : String ,
)