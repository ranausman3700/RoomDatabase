package com.example.roomdatabase.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NoteViewModelFactory(
    private val repository: NoteRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun<T : ViewModel> create(modelClass: Class<T>): T{
        try {
            val constructor = modelClass.getDeclaredConstructor(NoteRepository::class.java)
            return constructor.newInstance(repository)
        } catch (e: Exception){
            Log.e(TAG, "create: e.massage", )
        }
        return super.create(modelClass)
    }
}