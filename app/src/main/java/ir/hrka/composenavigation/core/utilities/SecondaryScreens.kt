package ir.hrka.composenavigation.core.utilities

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
sealed class SecondaryScreens(override val destination: String) : Route, Components {

    object Profile : SecondaryScreens("profile_screen") {
        override val topBarTitle: String
            get() = "Profile"
        override val topAppBarColors: TopAppBarColors
            @Composable
            get() = TopAppBarDefaults.topAppBarColors()
    }

    object Contact : SecondaryScreens("contact_screen") {
        override val topBarTitle: String
            get() = "Contact"
        override val topAppBarColors: TopAppBarColors
            @Composable
            get() = TopAppBarDefaults.topAppBarColors()
    }

    object EULA : SecondaryScreens("EULA_screen") {
        override val topBarTitle: String
            get() = "EULA"
        override val topAppBarColors: TopAppBarColors
            @Composable
            get() = TopAppBarDefaults.topAppBarColors()
    }

    object PrivacyPolicy : SecondaryScreens("privacy_policy_screen") {
        override val topBarTitle: String
            get() = "Privacy Policy"
        override val topAppBarColors: TopAppBarColors
            @Composable
            get() = TopAppBarDefaults.topAppBarColors()
    }
}