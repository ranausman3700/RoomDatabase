package com.example.roomdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.db.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 2 , exportSchema = false)
abstract class NoteDatabase(): RoomDatabase(){
    abstract fun getNoteDao() : NoteDao

    companion object {
        private const val DB_NAME = "note_database.db"
        @Volatile private  var instance: NoteDatabase? = null
        private val LOCK = Any()

        operator  fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            DB_NAME
        ).allowMainThreadQueries().build()
    }
}