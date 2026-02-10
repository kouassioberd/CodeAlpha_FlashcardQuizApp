package com.example.codealpha_flashcardquizapp.ui.screens

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.codealpha_flashcardquizapp.viewmodel.FlashcardViewModel


@Composable
fun FlashcardScreen(
    navController: NavController,
    viewModel: FlashcardViewModel
) {
    val cards by viewModel.flashcards.collectAsState()
    var index by rememberSaveable { mutableStateOf(0) }
    var showAnswer by remember { mutableStateOf(false)}


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add")}) {
                Text("+")
            }
        }
    ) { padding ->

        if (cards.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ){
                Text(
                    "No flashcard yet",
                    fontSize = 20.sp,
                )
            }
        } else {
            val card = cards[index]

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .shadow(8.dp, RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(16.dp))
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = if (showAnswer) card.answer else card.question,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )


                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { showAnswer = !showAnswer},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )

                ) {
                    Text( if (showAnswer) "Hide Answer" else "Show Answer")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = {
                            if (index > 0) {
                                index--
                                showAnswer = false
                            }
                        }
                    ) {
                        Text("Previous")
                    }

                    Button(
                        onClick = {
                            if (index < cards.size - 1) {
                                index++
                                showAnswer = false
                            }
                        }
                    ) {
                        Text("Next")
                    }
                }


                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                        onClick = {
                            // Navigate to edit screen with the card ID as a parameter
                            navController.navigate("edit/${card.id}")
                        }
                    ) {
                        Text("Edit")
                    }



                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                        onClick = {
                            viewModel.deleteFlashcard(card)
                            if (index > 0) {
                                index--
                            }
                        }
                    ) {
                        Text("Delete")
                    }
                }



            }
        }


    }
}