package io.github.japskiddin.notes.core.uikit.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.japskiddin.resources.Inter_Black
import io.github.japskiddin.resources.Inter_BlackItalic
import io.github.japskiddin.resources.Inter_Bold
import io.github.japskiddin.resources.Inter_BoldItalic
import io.github.japskiddin.resources.Inter_Italic
import io.github.japskiddin.resources.Inter_Light
import io.github.japskiddin.resources.Inter_LightItalic
import io.github.japskiddin.resources.Inter_Medium
import io.github.japskiddin.resources.Inter_MediumItalic
import io.github.japskiddin.resources.Inter_Regular
import io.github.japskiddin.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
public fun NotesTypography(): Typography {
    val inter = FontFamily(
        Font(Res.font.Inter_Light, FontWeight.Light),
        Font(Res.font.Inter_LightItalic, FontWeight.Light, FontStyle.Italic),
        Font(Res.font.Inter_Regular, FontWeight.Normal),
        Font(Res.font.Inter_Italic, FontWeight.Normal, FontStyle.Italic),
        Font(Res.font.Inter_Medium, FontWeight.Medium),
        Font(Res.font.Inter_MediumItalic, FontWeight.Medium, FontStyle.Italic),
        Font(Res.font.Inter_Bold, FontWeight.Bold),
        Font(Res.font.Inter_BoldItalic, FontWeight.Bold, FontStyle.Italic),
        Font(Res.font.Inter_Black, FontWeight.Black),
        Font(Res.font.Inter_BlackItalic, FontWeight.Black, FontStyle.Italic),
    )
    return Typography(
        titleLarge = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
        ),
        labelSmall = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        ),
    )
}
