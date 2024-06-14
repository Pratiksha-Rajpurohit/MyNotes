package com.pratiksha.mynotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratiksha.mynotes.db.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel (
    val repo : Repo
) : ViewModel() {

    fun insert(note : Notes){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insert(note)
        }

    }

    fun delete(note : Notes){
        viewModelScope.launch(Dispatchers.IO) {
            repo.delete(note)
        }

    }

    fun update(note : Notes){
        viewModelScope.launch(Dispatchers.IO) {
            repo.update(note)
        }

    }


    fun getAllNotes() = repo.getAllNotes()



}