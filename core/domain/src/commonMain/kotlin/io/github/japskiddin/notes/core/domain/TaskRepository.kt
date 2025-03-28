package io.github.japskiddin.notes.core.domain

import io.github.japskiddin.notes.core.model.Task
import kotlinx.coroutines.flow.Flow

public interface TaskRepository {
    public fun getAll(): Flow<List<Task>>
}
