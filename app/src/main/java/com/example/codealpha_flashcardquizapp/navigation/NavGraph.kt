package com.example.codealpha_flashcardquizapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codealpha_flashcardquizapp.ui.screens.AddFlashcardScreen
import com.example.codealpha_flashcardquizapp.ui.screens.EditFlashcardScreen
import com.example.codealpha_flashcardquizapp.ui.screens.FlashcardScreen
import com.example.codealpha_flashcardquizapp.viewmodel.FlashcardViewModel


@Composable
fun NavGraph (modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel: FlashcardViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ){
        composable("home") {
            FlashcardScreen(navController, viewModel)
        }
        composable("add") {
            AddFlashcardScreen(navController, viewModel)
        }
        composable("edit/{cardId}") { backStackEntry ->
            val cardId = backStackEntry.arguments?.getString("cardId")
            EditFlashcardScreen(navController = navController, cardId = cardId, viewModel = viewModel)
        }
    }
}