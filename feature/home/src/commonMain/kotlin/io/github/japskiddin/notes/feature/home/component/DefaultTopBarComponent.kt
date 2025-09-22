package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext

internal class DefaultTopBarComponent(
    componentContext: ComponentContext,
) : TopBarComponent, ComponentContext by componentContext {
    override fun onSettingsClick() = Unit

    override fun onSearchClick() = Unit
}
