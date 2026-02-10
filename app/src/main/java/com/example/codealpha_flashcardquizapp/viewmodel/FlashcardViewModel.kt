package com.example.codealpha_flashcardquizapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.codealpha_flashcardquizapp.data.database.FlashcardDatabase
import com.example.codealpha_flashcardquizapp.data.entity.Flashcard
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FlashcardViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = FlashcardDatabase
        .getDatabase(application)
        .flashcardDao()

    val flashcards = dao.getAllFlashcards()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun addFlashcard(question: String, answer: String) {
        viewModelScope.launch {
            dao.insertFlashcard(Flashcard(question = question, answer = answer))
        }
    }

    fun deleteFlashcard(card: Flashcard) {
        viewModelScope.launch {
            dao.deleteFlashcard(card)
        }
    }
}