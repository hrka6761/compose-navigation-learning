package ir.hrka.composenavigation.core.utilities

enum class PrimaryScreens(override val destination: String): Route {

    Home("home_screen"),
    Search("search_screen"),
    Favorites("favorites_screen"),
    Settings("settings_screen"),
    More("more_screen")
}