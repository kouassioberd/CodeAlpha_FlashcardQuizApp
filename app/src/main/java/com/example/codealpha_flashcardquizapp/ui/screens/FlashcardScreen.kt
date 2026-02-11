package com.example.codealpha_flashcardquizapp.ui.screens

import android.content.res.Configuration
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.codealpha_flashcardquizapp.data.entity.Flashcard
import com.example.codealpha_flashcardquizapp.viewmodel.FlashcardViewModel




@Composable
fun FlashcardScreen(
    navController: NavController,
    viewModel: FlashcardViewModel
) {
    val cards by viewModel.flashcards.collectAsState()
    var index by rememberSaveable { mutableStateOf(0) }
    var showAnswer by remember { mutableStateOf(false)}

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE


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
                    "No flashcard yet"
                )
            }
        } else {
            val card = cards[index]

           Box(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(padding),
               contentAlignment = Alignment.Center
           ) {

               Column(
                   modifier = Modifier
                       .fillMaxWidth(0.9f)// prevents full stretch on tablet
                       .fillMaxSize()
                       .verticalScroll(rememberScrollState())
                       .padding(24.dp),
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {

                   if (isLandscape) {
                       Row(
                           modifier = Modifier
                               .fillMaxWidth(),
                           horizontalArrangement = Arrangement.spacedBy(24.dp)
                       ) {

                           FlashcardContent(
                               card = card,
                               showAnswer = showAnswer,
                               modifier = Modifier
                                   .weight(1f)
                           )

                           FlashcardButtons(
                               index = index,
                               cardSize = cards.size,
                               onPrevious = {
                                   if (index > 0) {
                                       index--
                                       showAnswer = false
                                   }
                               },
                               onNext = {
                                   if (index < cards.size - 1) {
                                       index++
                                       showAnswer = false
                                   }
                               },
                               onEdit = {
                                   navController.navigate("edit/${card.id}")
                               },
                               onDelete = {
                                   viewModel.deleteFlashcard(card)
                                   if (index > 0) {
                                       index--
                                   }
                               },
                               showAnswer = showAnswer,
                               onToggleAnswer = {showAnswer = !showAnswer},
                               modifier = Modifier
                                   .weight(1f)
                           )
                       }

                   } else {

                       FlashcardContent(
                           card = card,
                           showAnswer = showAnswer
                       )
                       Spacer(modifier = Modifier.height(24.dp))

                       FlashcardButtons(
                           index = index,
                           cardSize = cards.size,
                           onPrevious = {
                               if (index > 0) {
                                   index--
                                   showAnswer = false
                               }
                           },
                           onNext = {
                               if (index < cards.size - 1) {
                                   index++
                                   showAnswer = false
                               }
                           },
                           onEdit = {
                               navController.navigate("edit/${card.id}")
                           },
                           onDelete = {
                               viewModel.deleteFlashcard(card)
                               if (index > 0) {
                                   index--
                               }
                           },
                           showAnswer = showAnswer,
                           onToggleAnswer = {showAnswer = !showAnswer}
                       )
                   }
               }
           }
        }
    }
}


@Composable
fun FlashcardContent(
    card: Flashcard,
    showAnswer: Boolean,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val dynamicHeigh = maxHeight * 0.5f

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dynamicHeigh)
                .shadow(8.dp, RoundedCornerShape(16.dp))
                .background(
                    MaterialTheme.colorScheme.surface,
                    RoundedCornerShape(16.dp)
                )
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (showAnswer) card.answer else card.question,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun FlashcardButtons(
    index: Int,
    cardSize: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    showAnswer: Boolean,
    onToggleAnswer: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = onToggleAnswer,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                if (showAnswer) "Hide Answer" else "Show Answer"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onPrevious,
                modifier = Modifier
                    .weight(1f),
                enabled = index > 0
            ) {
                Text("Previous")
            }

            Button(
                onClick = onNext,
                modifier = Modifier
                    .weight(1f),
                enabled = index < cardSize - 1
            ) {
                Text("Next")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onEdit,
                modifier = Modifier
                    .weight(1f)
            ) {
                Text("Edit")
            }

            Button(
                onClick = onDelete,
                modifier = Modifier
                    .weight(1f)
            ) {
                Text("Delete")
            }
        }
    }
}