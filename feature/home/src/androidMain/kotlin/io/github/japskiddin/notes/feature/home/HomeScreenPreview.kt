package io.github.japskiddin.notes.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import io.github.japskiddin.notes.core.uikit.theme.NotesTheme
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import io.github.japskiddin.notes.feature.home.component.TodoComponent
import io.github.japskiddin.notes.feature.home.component.ToolbarComponent

private class PreviewToolbarComponent : ToolbarComponent {
    override fun onSettingsClick() {
    }
}

private class PreviewTodoComponent : TodoComponent

private class PreviewHomeComponent : HomeComponent {
    override val toolbarComponent: ToolbarComponent = PreviewToolbarComponent()

    override val stack: Value<ChildStack<*, HomeComponent.HomeChild>> =
        MutableValue(
            ChildStack(
                configuration = Unit,
                instance = HomeComponent.HomeChild.Todo(PreviewTodoComponent())
            )
        )

    override fun onNotesClick() {
    }

    override fun onTodoClick() {
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    NotesTheme {
        HomeScreen(component = PreviewHomeComponent())
    }
}
