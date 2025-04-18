package io.github.japskiddin.notes.feature.home.component

import io.github.japskiddin.notes.core.model.Todo
import kotlinx.coroutines.flow.StateFlow

public interface TodoComponent {
    public val list: StateFlow<List<Todo>>
}
