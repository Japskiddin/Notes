package io.github.japskiddin.notes.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import io.github.japskiddin.notes.feature.home.component.HomeComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class Home(val component: HomeComponent) : Child
    }

    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext
        ): RootComponent
    }
}
