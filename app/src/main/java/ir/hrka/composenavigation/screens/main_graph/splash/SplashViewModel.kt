package ir.hrka.composenavigation.screens.main_graph.splash

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hrka.composenavigation.core.BaseViewModel
import ir.hrka.composenavigation.core.Constants.LOGIN_STATE_PREFERENCE_KEY
import ir.hrka.composenavigation.core.utilities.DataStoreManager
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : BaseViewModel() {

    val signInState: StateFlow<Boolean?> = dataStoreManager
        .readData(booleanPreferencesKey(LOGIN_STATE_PREFERENCE_KEY))
        .stateIn(viewModelScope, SharingStarted.Lazily, false)
}