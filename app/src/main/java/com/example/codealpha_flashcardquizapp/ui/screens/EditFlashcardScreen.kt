package com.example.codealpha_flashcardquizapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.codealpha_flashcardquizapp.viewmodel.FlashcardViewModel


@Composable
fun EditFlashcardScreen(
    navController: NavController,
    cardId: String?,
    viewModel: FlashcardViewModel
) {
    val cardIdInt = cardId?.toIntOrNull() ?: return
    val card = viewModel.flashcards.collectAsState().value.find { it.id == cardIdInt} ?: return

    var question by rememberSaveable { mutableStateOf(card.question) }
    var answer by rememberSaveable { mutableStateOf(card.answer) }


    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = question,
            onValueChange = { question = it},
            label = { Text("Question") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = answer,
            onValueChange = { answer = it},
            label = { Text("Answer") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.updateFlashcard(card.copy(question = question, answer = answer))
                navController.popBackStack()
            }
        ) {
            Text("Save")
        }
    }

}