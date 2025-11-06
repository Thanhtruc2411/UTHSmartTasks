package com.example.smarttasks.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smarttasks.ui.components.*

@Composable
fun ForgotPasswordScreen(navController: NavHostController) {
    PhoneFrame {
        AppHeader(navController)

        Text(
            "Forget Password?",
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(Modifier.height(8.dp))

        Text(
            "Enter your Email, we will send you a verification code.",
            fontSize = 13.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(16.dp))

        var email by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Your Email") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            singleLine = true
        )

        Spacer(Modifier.height(20.dp))

        BlueButton("Next") {
            // ✅ Điều hướng sang màn Verify và truyền email
            val emailText = email.text.trim()
            if (emailText.isNotEmpty()) {
                navController.navigate("verify/$emailText")
            }
        }
    }
}
