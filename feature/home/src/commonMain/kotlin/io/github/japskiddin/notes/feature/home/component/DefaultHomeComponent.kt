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

    private val _stack: Value<ChildStack<*, HomeComponent.Child>> = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialStack = { listOf(Config.Todo, Config.Notes) },
        childFactory = ::child
    )

    private val activeChild: HomeComponent.Child
        get() = _stack.value.active.instance

    override val stack: Value<ChildStack<*, HomeComponent.Child>> = _stack

    private fun child(
        config: Config,
        componentContext: ComponentContext,
    ): HomeComponent.Child =
        when (config) {
            is Config.Notes -> HomeComponent.Child.Notes(
                DefaultNotesComponent(componentContext)
            )

            is Config.Todo -> HomeComponent.Child.Todo(
                DefaultTodoComponent(componentContext)
            )
        }

    override val topBarComponent: TopBarComponent = DefaultTopBarComponent(
        childContext(key = "app_bar")
    )

    override val bottomBarComponent: BottomBarComponent = DefaultBottomBarComponent(
        componentContext = childContext(key = "bottom_bar"),
        onOpenTodo = {
            openPage(Config.Todo)
        },
        onOpenNotes = {
            openPage(Config.Notes)
        },
    )

    private fun openPage(page: Config) {
        navigation.bringToFront(page)
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
