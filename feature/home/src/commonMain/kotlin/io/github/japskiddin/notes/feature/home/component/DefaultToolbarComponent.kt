package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext

internal class DefaultToolbarComponent(
    componentContext: ComponentContext,
) : ToolbarComponent, ComponentContext by componentContext {
    override fun onSettingsClick() = Unit

    override fun onSearchClick() = Unit
}
