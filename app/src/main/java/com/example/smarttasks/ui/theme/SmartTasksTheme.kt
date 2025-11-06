package com.example.smarttasks.ui.theme



import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF4CAF50),
    secondary = androidx.compose.ui.graphics.Color(0xFF03A9F4),
    tertiary = androidx.compose.ui.graphics.Color(0xFFFFC107)
)

private val DarkColors = darkColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF81C784),
    secondary = androidx.compose.ui.graphics.Color(0xFF81D4FA),
    tertiary = androidx.compose.ui.graphics.Color(0xFFFFD54F)
)

@Composable
fun SmartTasksTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
