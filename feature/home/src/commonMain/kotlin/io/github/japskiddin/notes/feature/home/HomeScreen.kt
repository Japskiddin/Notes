package io.github.japskiddin.notes.feature.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import io.github.japskiddin.notes.feature.home.component.ToolbarComponent

@Composable
public fun HomeScreen(
    component: HomeComponent,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { ToolbarUi(component = component.toolbarComponent) }
    ) { paddingValues ->
    }
}

@Composable
private fun ToolbarUi(
    component: ToolbarComponent,
    modifier: Modifier = Modifier,
) {
}
