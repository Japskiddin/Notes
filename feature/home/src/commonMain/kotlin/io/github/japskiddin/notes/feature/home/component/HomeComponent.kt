package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

public interface HomeComponent {
    public val topBarComponent: TopBarComponent

    public val stack: Value<ChildStack<*, Child>>

    public fun onTodoClick()

    public fun onNotesClick()

    public sealed interface Child {
        public class Notes(public val component: NotesComponent) : Child

        public class Todo(public val component: TodoComponent) : Child
    }

    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext,
        ): HomeComponent
    }
}
