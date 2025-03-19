package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import io.github.japskiddin.notes.core.domain.NoteRepository
import io.github.japskiddin.notes.core.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class DefaultHomeComponent(
    componentContext: ComponentContext,
    private val noteRepository: NoteRepository,
) : HomeComponent, ComponentContext by componentContext {
    override val notes: StateFlow<List<Note>>
        get() = MutableStateFlow(emptyList())

    class Factory(
        private val noteRepository: NoteRepository
    ) : HomeComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext
        ): HomeComponent = DefaultHomeComponent(
            componentContext = componentContext,
            noteRepository = noteRepository,
        )
    }
}
