package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

internal class DefaultHomeComponent(
    componentContext: ComponentContext,
) : HomeComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    private val _stack: Value<ChildStack<*, HomeComponent.HomeChild>> = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialStack = { listOf(Config.Todo, Config.Notes) },
        childFactory = ::child
    )

    override val stack: Value<ChildStack<*, HomeComponent.HomeChild>> = _stack

    private fun child(
        config: Config,
        componentContext: ComponentContext,
    ): HomeComponent.HomeChild =
        when (config) {
            is Config.Notes -> HomeComponent.HomeChild.Notes(
                DefaultNotesComponent(componentContext)
            )

            is Config.Todo -> HomeComponent.HomeChild.Todo(
                DefaultTodoComponent(componentContext)
            )
        }

    override val toolbarComponent: ToolbarComponent = DefaultToolbarComponent(
        childContext(key = "toolbar")
    )

    override fun onNotesClick() {
        navigation.bringToFront(Config.Notes)
    }

    override fun onTodoClick() {
        navigation.bringToFront(Config.Todo)
    }

    @Serializable
    internal sealed interface Config {
        @Serializable
        data object Notes : Config

        @Serializable
        data object Todo : Config
    }

    class Factory : HomeComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext
        ): HomeComponent = DefaultHomeComponent(
            componentContext = componentContext,
        )
    }
}
