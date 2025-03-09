package io.github.japskiddin.notes.core.data

import io.github.japskiddin.notes.core.data.utils.toNote
import io.github.japskiddin.notes.core.database.dao.NoteDao
import io.github.japskiddin.notes.core.domain.NoteDataSource
import io.github.japskiddin.notes.core.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class NoteDataSourceImpl(
    private val noteDao: NoteDao
) : NoteDataSource {
    override fun getAll(): Flow<List<Note>> = noteDao.getAll().map { list ->
        list.map { noteDBO ->
            noteDBO.toNote()
        }
    }
}
