package io.github.japskiddin.notes.core.data

import io.github.japskiddin.notes.core.domain.NoteDataSource
import io.github.japskiddin.notes.core.domain.NoteRepository
import io.github.japskiddin.notes.core.model.Note
import kotlinx.coroutines.flow.Flow

internal class NoteRepositoryImpl(
    private val noteDataSource: NoteDataSource
) : NoteRepository {
    override fun getAll(): Flow<List<Note>> = noteDataSource.getAll()
}
