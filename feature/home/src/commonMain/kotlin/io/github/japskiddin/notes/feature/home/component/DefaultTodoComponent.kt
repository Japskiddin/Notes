package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import io.github.japskiddin.notes.core.common.AppDispatchers
import io.github.japskiddin.notes.core.domain.TodoRepository
import io.github.japskiddin.notes.core.model.Todo
import io.github.japskiddin.notes.core.utils.componentCoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class DefaultTodoComponent(
    componentContext: ComponentContext
) : TodoComponent, KoinComponent, ComponentContext by componentContext {
    private val todoRepository: TodoRepository by inject()
    private val appDispatchers: AppDispatchers by inject()

    private val coroutineScope = componentCoroutineScope(appDispatchers.main)

    override val list: StateFlow<List<Todo>>
        get() = todoRepository
            .getAll()
            .stateIn(
                scope = coroutineScope,
                initialValue = emptyList(),
                started = SharingStarted.WhileSubscribed(5000L)
            )
}
