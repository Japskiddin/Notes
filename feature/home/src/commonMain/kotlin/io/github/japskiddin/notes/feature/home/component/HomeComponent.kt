package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import io.github.japskiddin.notes.core.model.Note

public interface HomeComponent {
    public val toolbarComponent: ToolbarComponent

    public val notes: Value<List<Note>>

    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext,
        ): HomeComponent
    }
}
