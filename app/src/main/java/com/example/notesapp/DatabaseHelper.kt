package com.example.notesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "notes.db", null, 1) {

    private var sqLiteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table notes (text text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun saveNotes(text: String) {
        val contentValues = ContentValues()
        contentValues.put("text", text)
        sqLiteDatabase.insert("notes", null, contentValues)
    }
}