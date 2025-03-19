package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import io.github.japskiddin.notes.core.model.Note
import kotlinx.coroutines.flow.StateFlow

public interface HomeComponent {
    public val notes: StateFlow<List<Note>>

    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext,
        ): HomeComponent
    }
}
