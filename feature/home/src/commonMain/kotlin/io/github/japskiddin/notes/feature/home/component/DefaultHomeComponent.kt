package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import io.github.japskiddin.notes.feature.home.model.BottomBarItem
import kotlinx.serialization.Serializable

internal class DefaultHomeComponent(
    componentContext: ComponentContext,
) : HomeComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, HomeComponent.HomeChild>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialStack = { listOf(Config.Notes, Config.Todo) },
            childFactory = ::createChild
        )

    private fun createChild(
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

    override val bottomBarComponent: BottomBarComponent = DefaultBottomBarComponent(
        childContext(key = "bottomBar")
    )

    override fun onSelectTab(tab: BottomBarItem) =
        when (tab) {
            is BottomBarItem.Notes -> navigation.bringToFront(Config.Notes)

            is BottomBarItem.Todo -> navigation.bringToFront(Config.Todo)
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
