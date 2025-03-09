package io.github.japskiddin.notes.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import io.github.japskiddin.notes.core.database.entities.NoteDBO
import kotlinx.coroutines.flow.Flow

@Dao
public interface NoteDao {
    @Query("SELECT * FROM note")
    public fun get(): Flow<List<NoteDBO>>
}
