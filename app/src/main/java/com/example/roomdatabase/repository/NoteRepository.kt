package com.example.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase.db.NoteDatabase
import com.example.roomdatabase.db.entity.NoteEntity

class NoteRepository(
    private val noteDatabase: NoteDatabase
) {
    suspend fun insertNote(note: NoteEntity) = noteDatabase.getNoteDao().insertNote(note)

    suspend fun updateNote(note: NoteEntity) = noteDatabase.getNoteDao().updateNote(note)

    suspend fun deleteNote(note: NoteEntity) = noteDatabase.getNoteDao().deleteNote(note)

    suspend fun deleteNoteById(id: Int) = noteDatabase.getNoteDao().deleteNoteById(id)

    suspend fun clearNote() = noteDatabase.getNoteDao().clearNote()

     fun getAllNotes(): LiveData<List<NoteEntity>> = noteDatabase.getNoteDao().getAllNotes()
}