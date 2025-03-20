package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext

internal class DefaultBottomBarComponent(
    componentContext: ComponentContext,
) : BottomBarComponent, ComponentContext by componentContext {
    override fun onNotesClick() {
    }

    override fun onTodoClick() {
    }
}
