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
        override val topBarTitle: String
            get() = "Home"
        override val topAppBarColors: TopAppBarColors
            @Composable
            get() = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = Color.Red
            )
    }

    object Search : PrimaryScreens("search_screen") {
        override val topBarTitle: String
            get() = "Search"
        override val topAppBarColors: TopAppBarColors
            @Composable
            get() = TopAppBarDefaults.topAppBarColors()
    }

    object Favorites : PrimaryScreens("favorites_screen") {
        override val topBarTitle: String
            get() = "Favorites"
        override val topAppBarColors: TopAppBarColors
            @Composable
            get() = TopAppBarDefaults.topAppBarColors()
    }

    object Settings : PrimaryScreens("settings_screen") {
        override val topBarTitle: String
            get() = "Settings"
        override val topAppBarColors: TopAppBarColors
            @Composable
            get() = TopAppBarDefaults.topAppBarColors()
    }

    object More : PrimaryScreens("more_screen") {
        override val topBarTitle: String
            get() = "More"
        override val topAppBarColors: TopAppBarColors
            @Composable
            get() = TopAppBarDefaults.topAppBarColors()
    }
}