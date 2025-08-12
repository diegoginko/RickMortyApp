package com.diegoginko.rickmortyapp.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.diegoginko.rickmortyapp.ui.core.navigation.Routes
import com.diegoginko.rickmortyapp.ui.home.tabs.characters.CharactersScreen
import com.diegoginko.rickmortyapp.ui.home.tabs.episodes.EpisodesScreen

@Composable
fun NavigationBottomWrapper(navController: NavHostController){
    NavHost(navController= navController, startDestination = Routes.Episodes.route){
        composable(route = Routes.Episodes.route){
            EpisodesScreen()
        }
        composable(route = Routes.Characters.route){
            CharactersScreen()
        }
    }
}