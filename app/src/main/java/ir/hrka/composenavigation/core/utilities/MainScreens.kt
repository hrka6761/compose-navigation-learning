package ir.hrka.composenavigation.core.utilities

sealed class MainScreens(override val destination: String) : Route {

    object Splash : MainScreens("splash_screen")
    object SignIn : MainScreens("sign_in_screen")
    object Status : MainScreens("status_screen")
}