package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext

internal class DefaultBottomBarComponent(
    componentContext: ComponentContext,
    private val onOpenNotes: () -> Unit,
    private val onOpenTodo: () -> Unit,
) : BottomBarComponent, ComponentContext by componentContext {
    override fun onNotesClick() = onOpenNotes()

    override fun onTodoClick() = onOpenTodo()
}
