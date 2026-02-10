package com.example.codealpha_flashcardquizapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "flashcards")
data class Flashcard(
    @PrimaryKey(autoGenerate = true)
    val  id: Int = 0,
    val question: String,
    val answer: String
)
