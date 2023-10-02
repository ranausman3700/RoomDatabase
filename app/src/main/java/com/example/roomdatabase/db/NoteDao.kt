package com.example.roomdatabase.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabase.db.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: NoteEntity)

    @Update
    fun updateNote(note: NoteEntity)

  @Delete
   fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    fun getAllNotes(): LiveData<List<NoteEntity>>

   @Query("DELETE FROM note_table")
    fun clearNote()

   @Query("DELETE FROM note_table WHERE id= :id")
    fun deleteNoteById(id: Int)
}