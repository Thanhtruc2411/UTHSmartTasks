package com.example.smarttasks.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun VerifyCodeScreen(navController: NavHostController, email: String) {
    PhoneFrame {
        AppHeader(navController, showBack = true)

        Text("Verify Code", fontSize = 20.sp, color = Color.Black)
        Spacer(Modifier.height(8.dp))

        Text(
            "Enter the code we just sent to $email",
            fontSize = 13.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(24.dp))

        var code by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = code,
            onValueChange = { code = it },
            placeholder = { Text("Enter 4-digit code") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            singleLine = true
        )

        Spacer(Modifier.height(28.dp))

        BlueButton("Next") {
            val codeText = code.text.trim()
            if (codeText.isNotEmpty()) {
                navController.navigate("create/$email/$codeText")
            }
        }
    }
}
