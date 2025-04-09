package ir.hrka.composenavigation.screens.settings_graph.profile

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ir.hrka.composenavigation.core.Constants.TAG
import ir.hrka.composenavigation.core.utilities.SecondaryScreens.Profile

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Log.i(TAG, "ProfileScreen composition")
        Text(Profile.destination)
    }
}