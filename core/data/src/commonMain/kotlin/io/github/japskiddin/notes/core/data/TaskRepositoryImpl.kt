package io.github.japskiddin.notes.core.data

import io.github.japskiddin.notes.core.domain.TaskDataSource
import io.github.japskiddin.notes.core.domain.TaskRepository
import io.github.japskiddin.notes.core.model.Task
import kotlinx.coroutines.flow.Flow

internal class TaskRepositoryImpl(
    private val taskDataSource: TaskDataSource
) : TaskRepository {
    override fun getAll(): Flow<List<Task>> = taskDataSource.getAll()
}
