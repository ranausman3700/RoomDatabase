package com.example.roomdatabase

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.db.NoteDatabase
import com.example.roomdatabase.db.entity.NoteEntity
import com.example.roomdatabase.repository.NoteRepository
import com.example.roomdatabase.repository.NoteViewModel
import com.example.roomdatabase.repository.NoteViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InsertActivity : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvPriority: TextView
    private lateinit var btnInsert: Button

    //DB References
    private lateinit var viewModel: NoteViewModel
    private lateinit var noteDatabase: NoteDatabase
    private lateinit var repository: NoteRepository
    private lateinit var factory: NoteViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        tvTitle = findViewById(R.id.tvTitle)
        tvDescription = findViewById(R.id.tvDescription)
        tvPriority = findViewById(R.id.tvPriority)
        btnInsert = findViewById(R.id.btnInsert)

        //DB
        noteDatabase = NoteDatabase(this)
        repository = NoteRepository(noteDatabase)
        factory = NoteViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[NoteViewModel::class.java]

        btnInsert.setOnClickListener(){
            insertData()

        }
    }

   private fun insertData() {
        val title = tvTitle.text.toString()
        val desc = tvDescription.text.toString()
        val priority = tvPriority.text.toString()
        val note = NoteEntity(id = null, title = title, description = desc, priority = priority)
        if (title.isNotEmpty() && desc.isNotEmpty() && priority.isNotEmpty()){
            CoroutineScope(Dispatchers.Main).launch {
                viewModel.insertNote(note).also {

                    tvTitle.text = ""
                    tvPriority.text = ""
                    tvDescription.text = ""
                    Toast.makeText(applicationContext, "Data inserted successfully", Toast.LENGTH_SHORT).show()

                }

            }
        }else{
            Log.e(TAG, "insertData: Your data is not Updated")
        }
    }
}

