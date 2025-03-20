package ir.hrka.composenavigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import ir.hrka.composenavigation.core.Constants.TAG

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.i(TAG, "onCreate: before content composition")
        setContent { AppContent() }
        Log.i(TAG, "onCreate: after content composition")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
    }
}