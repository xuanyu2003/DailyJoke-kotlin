
package fi.oamk.joke_kotlin.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val CustomShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp)
)

@Composable
fun CustomTheme(content: @Composable () -> Unit) {

    MaterialTheme(
        colorScheme = ColorScheme(
            primary = CustomBlue,
            onPrimary = Color.White,
            primaryContainer = CustomBlue.copy(alpha = 0.12f),
            onPrimaryContainer = Color.Black,
            inversePrimary = CustomBlue,
            secondary = CustomOrange,
            onSecondary = Color.White,
            secondaryContainer = CustomOrange.copy(alpha = 0.12f),
            onSecondaryContainer = Color.Black,
            tertiary = CustomBlue,
            onTertiary = Color.White,
            tertiaryContainer = CustomBlue.copy(alpha = 0.12f),
            onTertiaryContainer = Color.Black,
            background = CustomBackground,
            onBackground = CustomTextColor,
            surface = CustomSurface,
            onSurface = CustomTextColor,
            surfaceVariant = CustomSurface.copy(alpha = 0.1f),
            onSurfaceVariant = CustomTextColor.copy(alpha = 0.6f),
            surfaceTint = CustomBlue,
            inverseSurface = CustomSurface.copy(alpha = 0.1f),
            inverseOnSurface = Color.White,
            error = CustomErrorColor,
            onError = Color.White,
            errorContainer = CustomErrorColor.copy(alpha = 0.2f),
            onErrorContainer = CustomErrorColor,
            outline = CustomTextColor.copy(alpha = 0.5f),
            outlineVariant = CustomSurface,
            scrim = CustomSurface.copy(alpha = 0.8f)
        ),
        shapes = CustomShapes,
        content = content
    )
}
