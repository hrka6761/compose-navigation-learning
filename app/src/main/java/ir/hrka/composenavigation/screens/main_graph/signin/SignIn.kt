package ir.hrka.composenavigation.screens.main_graph.signin

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.hrka.composenavigation.core.Constants.TAG
import ir.hrka.composenavigation.core.utilities.Graphs.PrimaryGraph
import ir.hrka.composenavigation.core.utilities.MainScreens.SignIn

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    snackBarHostState: SnackbarHostState
) {
    val viewModel: SignInViewModel = hiltViewModel()

    SignInScreenUI(
        modifier = modifier,
        navController = navController,
        snackBarHostState = snackBarHostState,
        viewModel = viewModel
    )
}

@Composable
fun SignInScreenUI(
    modifier: Modifier,
    navController: NavController,
    snackBarHostState: SnackbarHostState,
    viewModel: SignInViewModel
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var isUIEnable by remember { mutableStateOf(true) }
        var nameField by remember { mutableStateOf("") }
        val signInResult by viewModel.signInResult.collectAsState()

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            enabled = isUIEnable,
            value = nameField,
            onValueChange = { nameField = it },
            label = { Text("Enter your name") }
        )

        Spacer(modifier = modifier.height(8.dp))

        Button(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            enabled = nameField.isNotEmpty(),
            onClick = {
                isUIEnable = false
                viewModel.signIn(nameField)
            }
        ) {
            Text(if (isUIEnable) "SignIn" else "Signing...")

            Spacer(modifier = modifier.width(8.dp))

            if (!isUIEnable)
                CircularProgressIndicator(
                    modifier = modifier.size(25.dp),
                    strokeWidth = 2.dp
                )
        }

        LaunchedEffect(signInResult) {
            if (signInResult)
                navController.navigate(PrimaryGraph.destination) {
                    popUpTo(SignIn.destination) { inclusive = true }
                }
        }
    }
}