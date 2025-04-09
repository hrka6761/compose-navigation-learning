package ir.hrka.composenavigation.screens.bottom_sheet_graph.search

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import ir.hrka.composenavigation.core.Constants.TAG
import ir.hrka.composenavigation.core.utilities.PrimaryScreens.Search

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Log.i(TAG, "SearchScreen composition")
        val searchViewModel: SearchViewModel = hiltViewModel()

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = Search.topBarTitle
        )
        Text(
            text = "Search",
            textAlign = TextAlign.Center
        )
    }
}