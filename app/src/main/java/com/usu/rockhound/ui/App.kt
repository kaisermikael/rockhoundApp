package com.usu.rockhound.ui

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import com.usu.rockhound.ui.navigation.RootNavigation
import com.usu.rockhound.ui.theme.RockhoundApplicationTheme

@Composable
fun App() {
    RockhoundApplicationTheme {
        var permissionState by remember { mutableStateOf("requesting permission") }
        val launcher = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            permissionState = if (it) "permission granted" else "permission denied"
        }
        LaunchedEffect(true) {
            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }
        RootNavigation()
    }
}