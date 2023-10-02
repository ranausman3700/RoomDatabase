package com.example.roomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.db.entity.NoteEntity

class Adapter(private val list: List<NoteEntity>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.rvTitle)
        val descriptionTextView: TextView = itemView.findViewById(R.id.rvDesription)
        val priorityTextView: TextView = itemView.findViewById(R.id.rvPriority)
        val moreButton: ImageView = itemView.findViewById(R.id.btnMore)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val NoteEntity = list[position]
        holder.titleTextView.text = NoteEntity.title
        holder.descriptionTextView.text = NoteEntity.description
        holder.priorityTextView.text = NoteEntity.priority
        holder.moreButton.setOnClickListener{
            NoteEntity.id?.let { it ->

            }
        }
    }
}