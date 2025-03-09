package io.github.japskiddin.notes.core.data

import io.github.japskiddin.notes.core.domain.TodoDataSource
import io.github.japskiddin.notes.core.domain.TodoRepository
import io.github.japskiddin.notes.core.model.Task
import io.github.japskiddin.notes.core.model.Todo
import kotlinx.coroutines.flow.Flow

internal class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource
) : TodoRepository {
    override fun getAll(): Flow<List<Todo>> = todoDataSource.getAll()

    override fun getAllWithTasks(): Flow<Map<Todo, List<Task>>> = todoDataSource.getAllWithTasks()
}
