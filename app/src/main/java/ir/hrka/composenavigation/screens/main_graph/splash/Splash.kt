package ir.hrka.composenavigation.screens.main_graph.splash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import ir.hrka.composenavigation.R
import ir.hrka.composenavigation.core.Constants.TAG
import ir.hrka.composenavigation.core.utilities.Graphs.PrimaryGraph
import ir.hrka.composenavigation.core.utilities.MainScreens.Splash
import ir.hrka.composenavigation.core.utilities.MainScreens.SignIn
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    snackBarHostState: SnackbarHostState
) {
    val viewModel: SplashViewModel = hiltViewModel()
    val signInState by viewModel.signInState.collectAsStateWithLifecycle()

    SplashScreenUI(modifier = modifier)

    LaunchedEffect(signInState) {
        delay(2000)
        navController.navigate(if (signInState == true) PrimaryGraph.destination else SignIn.destination) {
            popUpTo(Splash.destination) { inclusive = true }
        }
    }
}

@Composable
fun SplashScreenUI(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = modifier.size(100.dp),
            painter = painterResource(R.drawable.compose_navigation_icon),
            contentDescription = null
        )

        Text(
            text = "Compose Navigation",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(64.dp))

        CircularProgressIndicator(
            modifier = modifier.size(30.dp),
            strokeWidth = 1.dp
        )
    }
}