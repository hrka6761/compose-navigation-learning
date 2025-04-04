package ir.hrka.composenavigation.core.utilities

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
interface Components {

    abstract val topBarTitle: String
    abstract val topAppBarColors: TopAppBarColors
        @Composable get
}