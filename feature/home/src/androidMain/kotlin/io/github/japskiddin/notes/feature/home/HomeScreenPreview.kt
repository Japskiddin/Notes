package io.github.japskiddin.notes.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import io.github.japskiddin.notes.core.model.Todo
import io.github.japskiddin.notes.core.uikit.theme.NotesTheme
import io.github.japskiddin.notes.feature.home.component.BottomBarComponent
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import io.github.japskiddin.notes.feature.home.component.TodoComponent
import io.github.japskiddin.notes.feature.home.component.TopBarComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private class PreviewTopBarComponent : TopBarComponent {
    override fun onSettingsClick() {
    }

    override fun onSearchClick() {
    }
}

private class PreviewBottomBarComponent : BottomBarComponent {
    override fun onTodoClick() {
    }

    override fun onNotesClick() {
    }
}

private class PreviewTodoComponent : TodoComponent {
    override val list: StateFlow<List<Todo>>
        get() = MutableStateFlow(emptyList())
}

private class PreviewHomeComponent : HomeComponent {
    override val topBarComponent: TopBarComponent = PreviewTopBarComponent()

    override val bottomBarComponent: BottomBarComponent = PreviewBottomBarComponent()

    override val stack: Value<ChildStack<*, HomeComponent.Child>> =
        MutableValue(
            ChildStack(
                configuration = Unit,
                instance = HomeComponent.Child.Todo(PreviewTodoComponent())
            )
        )
}

@Preview
@Composable
private fun HomeScreenPreview() {
    NotesTheme {
        HomeScreen(component = PreviewHomeComponent())
    }
}
