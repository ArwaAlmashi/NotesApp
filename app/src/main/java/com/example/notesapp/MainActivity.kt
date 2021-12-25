package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteList: ArrayList<String>

    private val databaseHelper by lazy { DatabaseHelper(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            sendButton.setOnClickListener {
                val note = noteTextEt.text.toString()
                databaseHelper.saveNotes(note)
                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()

            }
        }
    }
}