package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update

internal class DefaultToolbarComponent(
    componentContext: ComponentContext,
) : ToolbarComponent, ComponentContext by componentContext {
    private val _title = MutableValue("")

    override val title: Value<String>
        get() = _title

    override fun setTitle(title: String) {
        _title.update { title }
    }

    override fun onSettingsClick() {
    }
}
