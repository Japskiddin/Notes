package io.github.japskiddin.notes.feature.home.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

internal sealed class BottomBarItem(
    val title: String,
    val icon: ImageVector,
) {
    data object Notes : BottomBarItem(
        title = "Notes",
        icon = Icons.Default.Create,
    )

    data object Todo : BottomBarItem(
        title = "Todo",
        icon = Icons.Default.Home,
    )
}
