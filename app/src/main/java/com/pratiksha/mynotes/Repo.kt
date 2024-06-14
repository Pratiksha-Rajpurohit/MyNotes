package com.pratiksha.mynotes

import com.pratiksha.mynotes.db.Dao
import com.pratiksha.mynotes.db.Notes

class Repo(private val dao : Dao) {

    fun getAllNotes() = dao.getAllNotes()

    fun insert(note : Notes){
        dao.insert(note)
    }

    fun delete(note : Notes) {
        dao.delete(note)
    }

    fun update(note : Notes){
        dao.update(note)
    }






}