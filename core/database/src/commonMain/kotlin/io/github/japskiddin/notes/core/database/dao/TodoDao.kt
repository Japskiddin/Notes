package io.github.japskiddin.notes.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import io.github.japskiddin.notes.core.database.entities.TaskDBO
import io.github.japskiddin.notes.core.database.entities.TodoDBO
import kotlinx.coroutines.flow.Flow

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo")
    public fun getAll(): Flow<List<TodoDBO>>

    @Query(
        "SELECT * FROM todo " +
            "JOIN task ON todo.uid = task.todo_uid"
    )
    public fun getAllWithTasks(): Flow<Map<TodoDBO, List<TaskDBO>>>
}
