package com.pratiksha.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.pratiksha.mynotes.db.Notes
import com.pratiksha.mynotes.db.NotesDB

class WriteNote : AppCompatActivity() {

    private lateinit var notesDB: NotesDB
    private lateinit var repo : Repo
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var notesViewModelFactory: NotesViewModelFactory

    private lateinit var edNoteName : EditText
    private lateinit var edNoteContent : EditText
    private lateinit var saveImg : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_note)

        init()


        val bundle = intent.extras

        val noteName = bundle?.getString("noteName")
        val noteContent = bundle?.getString("noteContent")
        val id = bundle?.getInt("id")



        println("(((((((((((((( $bundle and $noteContent")

        edNoteName.setText(noteName)
        edNoteContent.setText(noteContent)
        saveImg.setOnClickListener {

            if(bundle != null ){
                val note = Notes(
                    id = id!!,
                    noteName = noteName!!,
                    noteContent = noteContent!!

                )

                notesViewModel.update(note)
                Toast.makeText(this, "note is updated", Toast.LENGTH_SHORT).show()
                startActivity(
                    Intent(
                        this, MainActivity::class.java
                    )
                )

            }else {

                val name = edNoteName.text.toString()
                val content = edNoteContent.text.toString()
                val note = Notes(
                    noteName = name,
                    noteContent = content
                )
                notesViewModel.insert(note)
                Toast.makeText(this, "note is Saved ", Toast.LENGTH_SHORT).show()
                startActivity(
                    Intent(
                        this, MainActivity::class.java
                    )
                )
            }
        }

    }

    private fun init(){

        notesDB = NotesDB(this)
        repo = Repo(notesDB.getNotesDao())
        notesViewModelFactory = NotesViewModelFactory(repo)
        notesViewModel = ViewModelProvider(this, notesViewModelFactory).get(NotesViewModel::class.java)

        edNoteContent = findViewById(R.id.edNoteContent)
        edNoteName = findViewById(R.id.edNoteName)
        saveImg = findViewById(R.id.imgSave)

    }

}