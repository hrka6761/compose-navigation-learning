package ir.hrka.composenavigation.core.utilities

enum class SecondaryScreens(override val destination: String): Route {

    Profile("profile_screen"),
    Contact("contact_screen"),
    EULA("EULA_screen"),
    PrivacyPolicy("privacy_policy_screen")
}