package ir.hrka.composenavigation.screens.main_graph.signin

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hrka.composenavigation.core.BaseViewModel
import ir.hrka.composenavigation.core.Constants.LOGIN_STATE_PREFERENCE_KEY
import ir.hrka.composenavigation.core.Constants.USERNAME_PREFERENCE_KEY
import ir.hrka.composenavigation.core.utilities.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : BaseViewModel() {

    private val _signInResult: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val signInResult: StateFlow<Boolean> = _signInResult


    fun signIn(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)
            saveUserName(name)
            _signInResult.value = true
        }
    }

    private suspend fun saveUserName(name: String) {
        dataStoreManager.saveData(stringPreferencesKey(USERNAME_PREFERENCE_KEY), name)
        dataStoreManager.saveData(booleanPreferencesKey(LOGIN_STATE_PREFERENCE_KEY), true)
    }
}