package com.example.roomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.db.entity.NoteEntity

class Adapter(private val List: List<NoteEntity>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }



    // return the number of the items in the list
    override fun getItemCount(): Int {
        return List.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.rvTitle)
        val descriptionTextView: TextView = itemView.findViewById(R.id.rvDesription)
        val priorityTextView: TextView = itemView.findViewById(R.id.rvPriority)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val NoteEntity = List[position]
        holder.titleTextView.text = NoteEntity.title
        holder.descriptionTextView.text = NoteEntity.description
        holder.priorityTextView.text = NoteEntity.priority
    }
}