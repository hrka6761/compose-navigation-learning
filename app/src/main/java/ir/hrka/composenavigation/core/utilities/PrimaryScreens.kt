package ir.hrka.composenavigation.core.utilities

sealed class PrimaryScreens(override val destination: String) : Route {

    object Home : PrimaryScreens("home_screen")
    object Search : PrimaryScreens("search_screen")
    object Favorites : PrimaryScreens("favorites_screen")
    object Settings : PrimaryScreens("settings_screen")
    object More : PrimaryScreens("more_screen")
}