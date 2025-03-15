package ir.hrka.composenavigation.core.utilities

enum class Screens(override val destination: String): Route {

    //Main graph
    Splash("splash_screen"),
    SignIn("sign_in_screen"),
    Main("main_screen"),
    Status("status_screen"),

    //Primary graph
    Home("home_screen"),
    Search("search_screen"),
    Favorites("favorites_screen"),
    Settings("settings_screen"),
    More("more_screen"),

    //Secondary graph
    Profile("profile_screen"),
    Contact("contact_screen"),
    EULA("EULA_screen"),
    PrivacyPolicy("privacy_policy_screen");
}