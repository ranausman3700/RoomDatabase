package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.db.NoteDatabase
import com.example.roomdatabase.db.entity.NoteEntity
import com.example.roomdatabase.repository.NoteRepository
import com.example.roomdatabase.repository.NoteViewModel
import com.example.roomdatabase.repository.NoteViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReadActivity : AppCompatActivity()  {
   private lateinit var myAdapter: Adapter
   private lateinit var list: ArrayList<NoteEntity>
    private lateinit var viewModel: NoteViewModel
    private lateinit var noteDatabase: NoteDatabase
    private lateinit var repository: NoteRepository
    private lateinit var factory: NoteViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)
        noteDatabase = NoteDatabase(this)
        repository = NoteRepository(noteDatabase)
        factory = NoteViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[NoteViewModel::class.java]
        list = ArrayList()
        val recyclerview : RecyclerView = findViewById(R.id.recyclerview)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        myAdapter = Adapter(list)
     recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter = myAdapter
        showData()

        //update delete

}
    private fun showData() {
        CoroutineScope(Dispatchers.Main).launch {
        viewModel.getAllNotes().observe(this@ReadActivity) { notes ->
            list.clear()
            list.addAll(notes)
            myAdapter.notifyDataSetChanged()

            }
        }
    }
}