package com.example.codealpha_flashcardquizapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalConfiguration
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

    val configuration = LocalConfiguration.current
    val isLandscape =
        configuration.orientation == Configuration.ORIENTATION_LANDSCAPE


    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            OutlinedTextField(
                value = question,
                onValueChange = { question = it },
                label = { Text("Question") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = answer,
                onValueChange = { answer = it },
                label = { Text("Answer") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (question.isNotBlank() && answer.isNotBlank()) {
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
}