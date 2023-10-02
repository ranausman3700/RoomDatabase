package com.example.roomdatabase.repository

import androidx.lifecycle.ViewModel
import com.example.roomdatabase.db.entity.NoteEntity

class NoteViewModel(
    private  val repository: NoteRepository
): ViewModel() {
    suspend fun insertNote(note: NoteEntity) = repository.insertNote(note)

    suspend fun updateNote(note: NoteEntity) = repository.updateNote(note)

    suspend fun deleteNote(note: NoteEntity) = repository.deleteNote(note)

    suspend fun deleteNoteById(id : Int) = repository.deleteNoteById(id)

    suspend fun clearNote() = repository.clearNote()

    fun getAllNotes() = repository.getAllNotes()
}