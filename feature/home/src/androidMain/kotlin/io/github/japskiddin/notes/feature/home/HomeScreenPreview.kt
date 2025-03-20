package io.github.japskiddin.notes.feature.home

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import io.github.japskiddin.notes.core.model.Note
import io.github.japskiddin.notes.feature.home.component.BottomBarComponent
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import io.github.japskiddin.notes.feature.home.component.ToolbarComponent

private class FakeBottomBarComponent : BottomBarComponent {
    override fun onNotesClick() {
    }

    override fun onTodoClick() {
    }
}

private class FakeToolbarComponent : ToolbarComponent {
    override fun onSettingsClick() {
    }
}

private class FakeHomeComponent : HomeComponent {
    override val toolbarComponent: ToolbarComponent = FakeToolbarComponent()

    override val bottomBarComponent: BottomBarComponent = FakeBottomBarComponent()

    override val notes: Value<List<Note>> = MutableValue(emptyList())
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(component = FakeHomeComponent())
    }
}
