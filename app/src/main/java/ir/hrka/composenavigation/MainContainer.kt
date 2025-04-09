package ir.hrka.composenavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import ir.hrka.composenavigation.core.utilities.Graphs.MainGraph
import ir.hrka.composenavigation.core.utilities.Graphs.PrimaryGraph
import ir.hrka.composenavigation.core.utilities.Graphs.SecondaryGraph
import ir.hrka.composenavigation.core.utilities.MainScreens.SignIn
import ir.hrka.composenavigation.core.utilities.MainScreens.Splash
import ir.hrka.composenavigation.core.utilities.MainScreens.Status
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.Favorites
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.Home
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.More
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.Search
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.Settings
import ir.hrka.composenavigation.core.utilities.SecondaryScreens.Contact
import ir.hrka.composenavigation.core.utilities.SecondaryScreens.EULA
import ir.hrka.composenavigation.core.utilities.SecondaryScreens.PrivacyPolicy
import ir.hrka.composenavigation.core.utilities.SecondaryScreens.Profile
import ir.hrka.composenavigation.core.utilities.bottomNavigationItems
import ir.hrka.composenavigation.screens.main_graph.signin.SignInScreen
import ir.hrka.composenavigation.screens.main_graph.splash.SplashScreen
import ir.hrka.composenavigation.screens.main_graph.status.StatusScreen
import ir.hrka.composenavigation.screens.bottom_sheet_graph.favorites.FavoritesScreen
import ir.hrka.composenavigation.screens.bottom_sheet_graph.home.HomeScreen
import ir.hrka.composenavigation.screens.bottom_sheet_graph.more.MoreScreen
import ir.hrka.composenavigation.screens.bottom_sheet_graph.search.SearchScreen
import ir.hrka.composenavigation.screens.bottom_sheet_graph.settings.SettingsScreen
import ir.hrka.composenavigation.screens.settings_graph.contact.ContactScreen
import ir.hrka.composenavigation.screens.settings_graph.eula.EULAScreen
import ir.hrka.composenavigation.screens.settings_graph.privacy_policy.PrivacyPolicyScreen
import ir.hrka.composenavigation.screens.settings_graph.profile.ProfileScreen
import ir.hrka.composenavigation.ui.theme.ComposeNavigationTheme

@Composable
fun AppContent(modifier: Modifier = Modifier) {
    ComposeNavigationTheme {
        val navController = rememberNavController()
        val snackBarHostState = remember { SnackbarHostState() }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentGraph = navBackStackEntry?.destination?.parent?.route
        val currentDestination = navBackStackEntry?.destination?.route

        Scaffold(
            topBar = {
                TopBar(
                    modifier = modifier,
                    currentGraph = currentGraph,
                    currentDestination = currentDestination
                )
            },
            bottomBar = {
                BottomBar(
                    modifier = modifier,
                    currentGraph = currentGraph,
                    currentDestination = currentDestination,
                    navController = navController
                )
            },
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier,
    currentGraph: String?,
    currentDestination: String?,
) {
    if (currentGraph != MainGraph.destination) {
        var barTitle: String? = null
        var barColors: TopAppBarColors? = null

        when (currentDestination) {
            Home.destination -> {
                barTitle = Home.topBarTitle
                barColors = Home.topAppBarColors
            }

            Search.destination -> {
                barTitle = Search.topBarTitle
                barColors = Search.topAppBarColors
            }

            Favorites.destination -> {
                barTitle = Favorites.topBarTitle
                barColors = Favorites.topAppBarColors
            }

            Settings.destination -> {
                barTitle = Settings.topBarTitle
                barColors = Settings.topAppBarColors
            }

            More.destination -> {
                barTitle = More.topBarTitle
                barColors = More.topAppBarColors
            }

            Profile.destination -> {
                barTitle = Profile.topBarTitle
                barColors = Profile.topAppBarColors
            }

            Contact.destination -> {
                barTitle = Contact.topBarTitle
                barColors = Contact.topAppBarColors
            }

            EULA.destination -> {
                barTitle = EULA.topBarTitle
                barColors = EULA.topAppBarColors
            }

            PrivacyPolicy.destination -> {
                barTitle = PrivacyPolicy.topBarTitle
                barColors = PrivacyPolicy.topAppBarColors
            }
        }

        TopAppBar(
            title = { Text(text = barTitle ?: "") },
            colors = barColors ?: TopAppBarDefaults.topAppBarColors()
        )
    }
}

@Composable
fun BottomBar(
    modifier: Modifier,
    currentGraph: String?,
    currentDestination: String?,
    navController: NavController
) {
    if (currentGraph == PrimaryGraph.destination)
        NavigationBar {
            bottomNavigationItems.forEach { item ->
                NavigationBarItem(
                    selected = item.destination == currentDestination,
                    onClick = {
                        if (item.destination != currentDestination)
                            navController.navigate(item.destination)
                    },
                    icon = {
                        Icon(
                            imageVector = if (item.destination == currentDestination) item.selectedIcon else item.unSelectedIcon,
                            contentDescription = item.title
                        )
                    }
                )
            }
        }
}