package ir.hrka.composenavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import ir.hrka.composenavigation.core.utilities.Graphs.MainGraph
import ir.hrka.composenavigation.core.utilities.Graphs.PrimaryGraph
import ir.hrka.composenavigation.core.utilities.Graphs.SecondaryGraph
import ir.hrka.composenavigation.core.utilities.MainScreens.Splash
import ir.hrka.composenavigation.core.utilities.MainScreens.SignIn
import ir.hrka.composenavigation.core.utilities.MainScreens.Status
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.Home
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.Search
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.Favorites
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.Settings
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.More
import ir.hrka.composenavigation.core.utilities.SecondaryScreens.Profile
import ir.hrka.composenavigation.core.utilities.SecondaryScreens.Contact
import ir.hrka.composenavigation.core.utilities.SecondaryScreens.EULA
import ir.hrka.composenavigation.core.utilities.SecondaryScreens.PrivacyPolicy
import ir.hrka.composenavigation.screens.main_graph.signin.SignInScreen
import ir.hrka.composenavigation.screens.main_graph.splash.SplashScreen
import ir.hrka.composenavigation.screens.main_graph.status.StatusScreen
import ir.hrka.composenavigation.screens.primary_graph.favorites.FavoritesScreen
import ir.hrka.composenavigation.screens.primary_graph.home.HomeScreen
import ir.hrka.composenavigation.screens.primary_graph.more.MoreScreen
import ir.hrka.composenavigation.screens.primary_graph.search.SearchScreen
import ir.hrka.composenavigation.screens.primary_graph.settings.SettingsScreen
import ir.hrka.composenavigation.screens.secondary_graph.contact.ContactScreen
import ir.hrka.composenavigation.screens.secondary_graph.eula.EULAScreen
import ir.hrka.composenavigation.screens.secondary_graph.privacy_policy.PrivacyPolicyScreen
import ir.hrka.composenavigation.screens.secondary_graph.profile.ProfileScreen
import ir.hrka.composenavigation.ui.theme.ComposeNavigationTheme

@Composable
fun AppContent(modifier: Modifier = Modifier) {
    ComposeNavigationTheme {
        val navController = rememberNavController()
        val snackBarHostState = remember { SnackbarHostState() }

        Scaffold(
            topBar = { TopBar() },
            bottomBar = { BottomBar() },
            snackbarHost = {
                SnackbarHost(
                    modifier = Modifier.fillMaxWidth(),
                    hostState = snackBarHostState
                )
            }
        ) { innerPaddings ->
            NavHost(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPaddings),
                navController = navController,
                startDestination = MainGraph.destination
            ) {
                navigation(
                    route = MainGraph.destination,
                    startDestination = Splash.destination
                ) {
                    composable(
                        route = Splash.destination
                    ) {
                        SplashScreen(
                            navController = navController,
                            snackBarHostState = snackBarHostState
                        )
                    }
                    composable(
                        route = SignIn.destination
                    ) {
                        SignInScreen(
                            navController = navController,
                            snackBarHostState = snackBarHostState
                        )
                    }
                    composable(
                        route = Status.destination
                    ) { StatusScreen() }
                }

                navigation(
                    route = PrimaryGraph.destination,
                    startDestination = Home.destination
                ) {
                    composable(
                        route = Home.destination
                    ) { HomeScreen() }
                    composable(
                        route = Search.destination
                    ) { SearchScreen() }
                    composable(
                        route = Favorites.destination
                    ) { FavoritesScreen() }
                    composable(
                        route = Settings.destination
                    ) { SettingsScreen() }
                    composable(
                        route = More.destination
                    ) { MoreScreen() }
                }

                navigation(
                    route = SecondaryGraph.destination,
                    startDestination = Profile.destination
                ) {
                    composable(
                        route = Profile.destination
                    ) { ProfileScreen() }
                    composable(
                        route = Contact.destination
                    ) { ContactScreen() }
                    composable(
                        route = EULA.destination
                    ) { EULAScreen() }
                    composable(
                        route = PrivacyPolicy.destination
                    ) { PrivacyPolicyScreen() }
                }
            }
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {

}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {

}