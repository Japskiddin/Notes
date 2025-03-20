package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext

internal class DefaultNotesComponent(
    componentContext: ComponentContext
) : NotesComponent, ComponentContext by componentContext
