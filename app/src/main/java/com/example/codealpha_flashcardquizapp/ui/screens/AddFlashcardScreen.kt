package com.example.codealpha_flashcardquizapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.codealpha_flashcardquizapp.viewmodel.FlashcardViewModel


@Composable
fun AddFlashcardScreen(
    navController: NavController,
    viewModel: FlashcardViewModel
) {
    var question by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
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
                if (question.isNotBlank() && answer.isNotBlank()){
                    viewModel.addFlashcard(question, answer)
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Flashcard")
        }


    }
}