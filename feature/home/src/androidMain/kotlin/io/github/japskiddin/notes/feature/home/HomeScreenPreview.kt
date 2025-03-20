package io.github.japskiddin.notes.feature.home

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import io.github.japskiddin.notes.core.model.Note
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import io.github.japskiddin.notes.feature.home.component.ToolbarComponent

private class FakeToolbarComponent : ToolbarComponent

private class FakeHomeComponent : HomeComponent {
    override val toolbarComponent: ToolbarComponent
        get() = FakeToolbarComponent()

    override val notes: Value<List<Note>>
        get() = MutableValue(emptyList())
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(component = FakeHomeComponent())
    }
}
