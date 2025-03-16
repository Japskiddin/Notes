package io.github.japskiddin.notes.feature.home.uiLogic.usecase

import io.github.japskiddin.notes.core.domain.NoteRepository
import io.github.japskiddin.notes.core.model.Note
import kotlinx.coroutines.flow.Flow

internal class GetAllNotesUseCase(
    private val noteRepository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> = noteRepository.getAll()
}
