package com.example.codealpha_flashcardquizapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.codealpha_flashcardquizapp.data.dao.FlashcardDao
import com.example.codealpha_flashcardquizapp.data.entity.Flashcard


@Database(entities = [Flashcard::class], version = 1)
abstract class FlashcardDatabase : RoomDatabase() {

    abstract fun flashcardDao() : FlashcardDao

    companion object {
        @Volatile
        private var INSTANCE: FlashcardDatabase? = null

        fun getDatabase(context: Context): FlashcardDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    FlashcardDatabase::class.java,
                    "flashcard_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}