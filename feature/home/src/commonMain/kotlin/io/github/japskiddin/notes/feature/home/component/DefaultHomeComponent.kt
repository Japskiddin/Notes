package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import io.github.japskiddin.notes.core.domain.NoteRepository
import io.github.japskiddin.notes.core.model.Note

internal class DefaultHomeComponent(
    componentContext: ComponentContext,
    private val noteRepository: NoteRepository,
) : HomeComponent, ComponentContext by componentContext {
    override val toolbarComponent: ToolbarComponent = DefaultToolbarComponent(
        childContext(key = "toolbar")
    )

    override val notes: Value<List<Note>>
        get() = MutableValue(emptyList())

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
