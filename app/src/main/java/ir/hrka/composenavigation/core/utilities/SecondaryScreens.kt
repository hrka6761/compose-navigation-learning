package ir.hrka.composenavigation.core.utilities

sealed class SecondaryScreens(override val destination: String) : Route {

    object Profile : SecondaryScreens("profile_screen")
    object Contact : SecondaryScreens("contact_screen")
    object EULA : SecondaryScreens("EULA_screen")
    object PrivacyPolicy : SecondaryScreens("privacy_policy_screen")
}