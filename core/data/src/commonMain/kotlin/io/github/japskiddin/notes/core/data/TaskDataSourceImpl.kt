package io.github.japskiddin.notes.core.data

import io.github.japskiddin.notes.core.data.utils.toTask
import io.github.japskiddin.notes.core.database.dao.TaskDao
import io.github.japskiddin.notes.core.domain.TaskDataSource
import io.github.japskiddin.notes.core.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class TaskDataSourceImpl(
    private val taskDao: TaskDao
) : TaskDataSource {
    override fun getAll(): Flow<List<Task>> = taskDao.getAll().map { list ->
        list.map { taskDBO ->
            taskDBO.toTask()
        }
    }
}
