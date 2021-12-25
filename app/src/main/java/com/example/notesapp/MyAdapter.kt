package com.example.notesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.RowBinding

class MyAdapter(var noteList: ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    class MyHolder( val binding: RowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyHolder {
        return MyHolder(
            RowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyAdapter.MyHolder, position: Int) {
        holder.binding.apply {
            noteTv.text = noteList[position]
        }
    }

    override fun getItemCount() = noteList.size
}