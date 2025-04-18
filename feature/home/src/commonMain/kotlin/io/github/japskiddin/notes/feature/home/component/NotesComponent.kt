package io.github.japskiddin.notes.feature.home.component

import io.github.japskiddin.notes.core.model.Note
import kotlinx.coroutines.flow.StateFlow

public interface NotesComponent {
    public val list: StateFlow<List<Note>>
}
