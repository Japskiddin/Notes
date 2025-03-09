package io.github.japskiddin.notes.core.domain

import io.github.japskiddin.notes.core.model.Note
import kotlinx.coroutines.flow.Flow

public interface NoteDataSource {
    public fun getAll(): Flow<List<Note>>
}
