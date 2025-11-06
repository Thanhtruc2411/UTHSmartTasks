package com.example.smarttasks.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smarttasks.ui.screens.CreatePasswordScreen
import com.example.smarttasks.ui.screens.ForgotPasswordScreen
import com.example.smarttasks.ui.screens.VerifyCodeScreen
import com.example.smarttasks.ui.screens.ConfirmScreen
import com.example.smarttasks.ui.theme.SmartTasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartTasksApp()
        }
    }
}

@Composable
fun SmartTasksApp() {
    SmartTasksTheme {
        val navController = rememberNavController()
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(navController, startDestination = "forgot") {
                composable("forgot") { ForgotPasswordScreen(navController) }
                composable("verify/{email}") { backStackEntry ->
                    val email = backStackEntry.arguments?.getString("email") ?: ""
                    VerifyCodeScreen(navController, email)
                }
                composable("create/{email}/{code}") { backStackEntry ->
                    val email = backStackEntry.arguments?.getString("email") ?: ""
                    val code = backStackEntry.arguments?.getString("code") ?: ""
                    CreatePasswordScreen(navController, email, code)
                }
                composable("confirm/{email}/{code}/{password}") { backStackEntry ->
                    val email = backStackEntry.arguments?.getString("email") ?: ""
                    val code = backStackEntry.arguments?.getString("code") ?: ""
                    val password = backStackEntry.arguments?.getString("password") ?: ""
                    ConfirmScreen(navController, email, code, password)
                }
            }

        }
    }
}
