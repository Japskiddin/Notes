package io.github.japskiddin.notes.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import io.github.japskiddin.notes.core.database.entities.TaskDBO
import kotlinx.coroutines.flow.Flow

@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    public fun getAll(): Flow<List<TaskDBO>>
}
