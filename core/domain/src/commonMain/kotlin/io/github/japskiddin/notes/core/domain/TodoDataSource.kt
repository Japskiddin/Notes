package io.github.japskiddin.notes.core.domain

import io.github.japskiddin.notes.core.model.Task
import io.github.japskiddin.notes.core.model.Todo
import kotlinx.coroutines.flow.Flow

public interface TodoDataSource {
    public fun getAll(): Flow<List<Todo>>

    public fun getAllWithTasks(): Flow<Map<Todo, List<Task>>>
}
