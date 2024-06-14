package com.pratiksha.mynotes.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@androidx.room.Dao
interface Dao {

    @Insert
    fun insert(note: Notes)

    @Delete
    fun delete(note: Notes)

    @Update
    fun update(note : Notes)

    @Query("Select * from notesTable")
    fun getAllNotes() : LiveData<List<Notes>>


}