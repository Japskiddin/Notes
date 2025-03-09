package io.github.japskiddin.notes.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import io.github.japskiddin.notes.core.database.entities.TodoDBO
import kotlinx.coroutines.flow.Flow

@Dao
public interface TodoDao {
    @Query("SELECT * FROM ${TodoDBO.TABLE_NAME}")
    public fun get(): Flow<List<TodoDBO>>
}
