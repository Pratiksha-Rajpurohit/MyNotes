package com.pratiksha.mynotes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pratiksha.mynotes.db.Notes
import com.pratiksha.mynotes.db.NotesDB

class MainActivity : AppCompatActivity() , NotesAdaptor.ClickListener{

    private lateinit var repo: Repo
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var notesViewModelFactory: NotesViewModelFactory
    private lateinit var notesDB: NotesDB
    private lateinit var rv : RecyclerView
    private lateinit var notesAdaptor: NotesAdaptor
    private lateinit var fab : FloatingActionButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        init()



        notesViewModel.getAllNotes().observe(this){
            notesAdaptor = NotesAdaptor(it , this)
            rv.adapter = notesAdaptor
            rv.layoutManager = GridLayoutManager(this,1)
        }

        fab.setOnClickListener{
            startActivity(
                Intent(
                    this,WriteNote::class.java
                )
            )
        }







    }

    private fun init(){
        notesDB = NotesDB(this)
        repo = Repo(notesDB.getNotesDao())
        notesViewModelFactory = NotesViewModelFactory(repo)
        notesViewModel = ViewModelProvider(this,notesViewModelFactory).get(NotesViewModel::class.java)
        rv = findViewById(R.id.rv)
        fab = findViewById(R.id.fab)


    }

    override fun delete(note: Notes) {
        notesViewModel.delete(note)
    }



    override fun  showNote(note: Notes) {

        val bundle = Bundle().apply {
            putInt("id",note.id)
            putString("noteName" , note.noteName)
            putString("noteContent" , note.noteContent)
        }

        val intent = Intent(
            this , ShowNote::class.java
        ).apply {
            putExtras(bundle)
        }




        startActivity(
          intent
        )




    }
}