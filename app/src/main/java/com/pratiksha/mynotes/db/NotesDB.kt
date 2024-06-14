package com.pratiksha.mynotes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pratiksha.mynotes.ShowNote

@Database(
    entities = [Notes :: class],
    version = 1,
    exportSchema = false

)
abstract class NotesDB : RoomDatabase() {

    abstract fun getNotesDao() : Dao

    companion object{

        private const val DB_Name = "note_database.db"
        private var instance : NotesDB? =null
        operator fun invoke(context: Context) = instance ?: synchronized(Any()){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NotesDB::class.java,
            DB_Name
        ).build()


    }


}