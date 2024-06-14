package com.pratiksha.mynotes

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.pratiksha.mynotes.databinding.ActivityShowNoteBinding
import com.pratiksha.mynotes.db.NotesDB

class ShowNote : AppCompatActivity() {

    private lateinit var tvNoteName : TextView
    private lateinit var tvNoteContent : TextView
    private lateinit var editImg : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_note)

        init()

        val bundle = intent.extras

        val id = bundle?.getInt("id")
        val noteName = bundle?.getString("noteName")
        val noteContent = bundle?.getString("noteContent")

        println("(((((((((((((( $noteName and $noteContent")

        tvNoteName.text = noteName
        tvNoteContent.text = noteContent

        editImg.setOnClickListener {

                val bundle2 = Bundle().apply {

                    putInt("id", id!!)
                    putString("noteName", noteName)
                    putString("noteContent", noteContent)
                }


                val intent = Intent(
                    this, WriteNote::class.java
                ).apply {
                    putExtras(bundle2)
                }


                startActivity(
                    intent
                )

        }

    }



    private fun init(){

        tvNoteContent = findViewById(R.id.edNoteContent)
        tvNoteName = findViewById(R.id.edNoteName)
        editImg = findViewById(R.id.imgSave)

    }
}