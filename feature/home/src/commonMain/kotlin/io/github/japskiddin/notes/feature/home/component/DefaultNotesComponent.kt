package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import io.github.japskiddin.notes.core.common.AppDispatchers
import io.github.japskiddin.notes.core.domain.NoteRepository
import io.github.japskiddin.notes.core.model.Note
import io.github.japskiddin.notes.core.utils.componentCoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class DefaultNotesComponent(
    componentContext: ComponentContext,
) : NotesComponent, KoinComponent, ComponentContext by componentContext {
    private val noteRepository: NoteRepository by inject()
    private val appDispatchers: AppDispatchers by inject()

    private val coroutineScope = componentCoroutineScope(appDispatchers.main)

    override val list: StateFlow<List<Note>>
        get() = noteRepository
            .getAll()
            .stateIn(
                scope = coroutineScope,
                initialValue = emptyList(),
                started = SharingStarted.WhileSubscribed(5000L)
            )
}
