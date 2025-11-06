package com.example.smarttasks.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smarttasks.ui.components.*

@Composable
fun CreatePasswordScreen(
    navController: NavHostController,
    email: String,
    code: String
) {
    PhoneFrame {
        AppHeader(navController, showBack = true)

        Text("Create new password", fontSize = 20.sp, color = Color.Black)
        Spacer(Modifier.height(8.dp))

        Text(
            "Your new password must be different from previously used password",
            fontSize = 13.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(16.dp))

        var pass by remember { mutableStateOf("") }
        var confirm by remember { mutableStateOf("") }

        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            placeholder = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = confirm,
            onValueChange = { confirm = it },
            placeholder = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(Modifier.height(18.dp))

        BlueButton("Next") {
            val passwordText = pass.trim()
            val confirmText = confirm.trim()

            // Kiểm tra xác nhận trùng mật khẩu
            if (passwordText.isNotEmpty() && passwordText == confirmText) {
                navController.navigate("confirm/$email/$code/$passwordText")
            }
        }
    }
}
