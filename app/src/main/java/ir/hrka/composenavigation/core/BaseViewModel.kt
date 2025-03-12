package ir.hrka.composenavigation.core

import android.util.Log
import androidx.lifecycle.ViewModel
import ir.hrka.composenavigation.core.Constants.TAG

open class BaseViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()

        Log.i(TAG, "onCleared ${this.javaClass.simpleName}")
    }
}