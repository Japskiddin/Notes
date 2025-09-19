package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.value.Value

public interface ToolbarComponent {
    public val title: Value<String>

    public fun setTitle(title: String)

    public fun onSettingsClick()
}
