package ir.hrka.composenavigation.core.utilities

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val destination: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

val bottomNavigationItems = listOf<BottomNavigationItem>(
    BottomNavigationItem(
        title = "Home",
        destination = PrimaryScreens.Home.destination,
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        hasNews = false
    ),
    BottomNavigationItem(
        title = "Search",
        destination = PrimaryScreens.Search.destination,
        selectedIcon = Icons.Filled.Search,
        unSelectedIcon = Icons.Outlined.Search,
        hasNews = false
    ),
    BottomNavigationItem(
        title = "Favorite",
        destination = PrimaryScreens.Favorites.destination,
        selectedIcon = Icons.Filled.Favorite,
        unSelectedIcon = Icons.Outlined.FavoriteBorder,
        hasNews = false
    ),
    BottomNavigationItem(
        title = "Settings",
        destination = PrimaryScreens.Settings.destination,
        selectedIcon = Icons.Filled.Settings,
        unSelectedIcon = Icons.Outlined.Settings,
        hasNews = false
    ),
    BottomNavigationItem(
        title = "More",
        destination = PrimaryScreens.More.destination,
        selectedIcon = Icons.Filled.Menu,
        unSelectedIcon = Icons.Outlined.Menu,
        hasNews = false
    )
)