package com.example.smarttasks.ui.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smarttasks.R


@Composable
fun PhoneFrame(content: @Composable ColumnScope.() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(320.dp)
                .fillMaxHeight(0.95f)
                .background(Color(0xFF111111), RoundedCornerShape(28.dp))
                .padding(18.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White, RoundedCornerShape(28.dp))
                    .padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                content = content
            )
        }
    }
}

@Composable
fun AppHeader(navController: NavHostController?, showBack: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showBack) {
            IconButton(onClick = { navController?.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF1E88E5)
                )
            }
        } else {
            Spacer(modifier = Modifier.width(48.dp))
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // 🟦 Thêm logo UTH ở trên
            Image(
                painter = painterResource(id = R.drawable.logo_uth), // logo trong res/drawable
                contentDescription = "UTH Logo",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text("UTH", color = Color(0xFF0E8F87), fontSize = 20.sp)
            Text("SmartTasks", color = Color(0xFF1E88E5), fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(48.dp))
    }
    Spacer(modifier = Modifier.height(18.dp))
}

@Composable
fun BlueButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        shape = RoundedCornerShape(28.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5))
    ) {
        Text(text = text, color = Color.White, fontSize = 16.sp)
    }
}

