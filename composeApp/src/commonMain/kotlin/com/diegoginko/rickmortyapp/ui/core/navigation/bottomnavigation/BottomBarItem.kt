package com.diegoginko.rickmortyapp.ui.core.navigation.bottomnavigation

import androidx.compose.material3.Icon

import androidx.compose.runtime.Composable
import com.diegoginko.rickmortyapp.ui.core.navigation.Routes

sealed class BottomBarItem {
    abstract val route: String
    abstract val title: String
    abstract val icon: @Composable () -> Unit

    data class Episodes(
        override val route: String = Routes.Episodes.route,
        override val title: String = "Episodes",
        override val icon: @Composable (() -> Unit) = {

        }
    ): BottomBarItem(

    )

    data class Characters(
        override val route: String = Routes.Characters.route,
        override val title: String = "Characters",
        override val icon: @Composable (() -> Unit) = {

        }
    ): BottomBarItem()
}