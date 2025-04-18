package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

public interface HomeComponent {
    public val toolbarComponent: ToolbarComponent

    public val stack: Value<ChildStack<*, HomeChild>>

    public fun onTodoClick()

    public fun onNotesClick()

    public sealed interface HomeChild {
        public class Notes(public val component: NotesComponent) : HomeChild

        public class Todo(public val component: TodoComponent) : HomeChild
    }

    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext,
        ): HomeComponent
    }
}
