package ir.hrka.composenavigation.core.utilities

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
sealed class PrimaryScreens(override val destination: String) : Route, Components {

    object Home : PrimaryScreens("home_screen") {
        override val topBarTitle: String = "Home"
    }

    object Search : PrimaryScreens("search_screen") {
        override val topBarTitle: String = "Search"
    }

    object Favorites : PrimaryScreens("favorites_screen") {
        override val topBarTitle: String = "Favorites"
    }

    object Settings : PrimaryScreens("settings_screen") {
        override val topBarTitle: String = "Settings"
    }

    object More : PrimaryScreens("more_screen") {
        override val topBarTitle: String = "More"
    }
}