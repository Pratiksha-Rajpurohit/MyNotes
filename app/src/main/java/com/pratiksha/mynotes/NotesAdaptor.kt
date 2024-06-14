package com.pratiksha.mynotes

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pratiksha.mynotes.db.Notes

class NotesAdaptor(
    val listOfNotes : List<Notes>,
    val clickListener: ClickListener
) : RecyclerView.Adapter<NotesAdaptor.NotesViewHolder>()  {

    class NotesViewHolder(
        itemView : View
    ): RecyclerView.ViewHolder(itemView) {
        val textName : TextView = itemView.findViewById(R.id.tvNoteName)
        val textContent : TextView = itemView.findViewById(R.id.tvNoteContent)
        val deleteNote : ImageView = itemView.findViewById(R.id.img_deleteNote)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_note , parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNotes = listOfNotes[position]
        println(" $position :: - $currentNotes ++++++++++++++++++++++++++++")
        holder.textName.text = currentNotes.noteName
        holder.textContent.text = currentNotes.noteContent

        holder.deleteNote.setOnClickListener {
            clickListener.delete(currentNotes)
        }

        holder.itemView.setOnClickListener{
            clickListener.showNote(currentNotes)
        }


    }

    override fun getItemCount(): Int {
        return listOfNotes.size
    }

    interface ClickListener{
        fun delete(note : Notes)
        fun showNote(note : Notes)
    }


}