package com.example.notesapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ActivityMainBinding
import android.view.WindowManager

import android.os.Build
import android.view.Window
import android.R

import android.graphics.drawable.Drawable





class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteList: ArrayList<String>
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    private val databaseHelper by lazy { DatabaseHelper(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        noteList = arrayListOf()
        recyclerView = binding.recyclerview
        myAdapter = MyAdapter(noteList)
        recyclerView.adapter = myAdapter


        binding.apply {
            sendButton.setOnClickListener {
                val note = noteTextEt.text.toString()
                databaseHelper.saveNotes(note)
                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
                noteList = databaseHelper.readData()
                myAdapter.update(noteList)
                noteTextEt.setText("")
            }
        }
    }
}