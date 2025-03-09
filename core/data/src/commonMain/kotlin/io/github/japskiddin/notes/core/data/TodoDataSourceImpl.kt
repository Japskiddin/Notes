package io.github.japskiddin.notes.core.data

import io.github.japskiddin.notes.core.data.utils.toTask
import io.github.japskiddin.notes.core.data.utils.toTodo
import io.github.japskiddin.notes.core.database.dao.TodoDao
import io.github.japskiddin.notes.core.domain.TodoDataSource
import io.github.japskiddin.notes.core.model.Task
import io.github.japskiddin.notes.core.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class TodoDataSourceImpl(
    private val todoDao: TodoDao,
) : TodoDataSource {
    override fun getAll(): Flow<List<Todo>> = todoDao.getAll().map { list ->
        list.map { todoDBO ->
            todoDBO.toTodo()
        }
    }

    override fun getAllWithTasks(): Flow<Map<Todo, List<Task>>> = todoDao.getAllWithTasks().map { items ->
        items
            .mapKeys { entry ->
                entry.key.toTodo()
            }
            .mapValues { entry ->
                entry.value.map { taskDBO ->
                    taskDBO.toTask()
                }
            }
    }
}
