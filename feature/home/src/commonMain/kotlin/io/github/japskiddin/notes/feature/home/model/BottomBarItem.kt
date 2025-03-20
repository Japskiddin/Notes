package io.github.japskiddin.notes.feature.home.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

public sealed class BottomBarItem(
    public val title: String,
    public val icon: ImageVector,
) {
    public data object Notes : BottomBarItem(
        title = "Notes",
        icon = Icons.Default.Create,
    )

    public data object Todo : BottomBarItem(
        title = "Todo",
        icon = Icons.Default.Home,
    )
}
