package ir.hrka.composenavigation.core.utilities

enum class MainScreens(override val destination: String): Route {

    Splash("splash_screen"),
    SignIn("sign_in_screen"),
    Main("main_screen"),
    Status("status_screen")
}