package ir.hrka.composenavigation.screens

enum class Screens(val destination: String) {

    //Main screens
    Splash("splash_screen"),
    SignIn("sign_in_screen"),
    Main("main_screen"),
    Status("status_screen"),

    //Primary screens
    Home("home_screen"),
    Search("search_screen"),
    Favorites("favorites_screen"),
    Settings("settings_screen"),
    More("more_screen"),

    //Secondary screens
    Profile("profile_screen"),
    Contact("contact_screen"),
    EULA("EULA_screen"),
    PrivacyPolicy("privacy_policy_screen");
}