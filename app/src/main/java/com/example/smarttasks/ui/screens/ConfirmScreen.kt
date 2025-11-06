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
fun ConfirmScreen(
    navController: NavHostController,
    email: String,
    code: String,
    password: String
) {
    PhoneFrame {
        AppHeader(navController, showBack = true)

        Text("Confirm Information", fontSize = 20.sp)
        Spacer(Modifier.height(8.dp))
        Text(
            "Please review your details before submitting",
            fontSize = 13.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(18.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {},
            label = { Text("Email") },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = code,
            onValueChange = {},
            label = { Text("Verification Code") },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {},
            label = { Text("Password") },
            readOnly = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(Modifier.height(18.dp))
        BlueButton("Submit") {
            // TODO: Sau này bạn có thể gọi API reset password ở đây
        }
    }
}
