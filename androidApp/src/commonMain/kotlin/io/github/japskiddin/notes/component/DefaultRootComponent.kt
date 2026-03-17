package io.github.japskiddin.notes.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext,
    private val homeComponentFactory: HomeComponent.Factory,
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    private val _stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = Config.Home,
        serializer = Config.serializer(),
        handleBackButton = true,
        childFactory = ::child,
    )

    override val stack: Value<ChildStack<*, RootComponent.Child>> = _stack

    private fun child(
        config: Config,
        componentContext: ComponentContext,
    ): RootComponent.Child = when (config) {
        is Config.Home -> RootComponent.Child.Home(
            homeComponentFactory(componentContext)
        )
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Home : Config
    }

    class Factory(
        private val homeComponentFactory: HomeComponent.Factory,
    ) : RootComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext
        ): RootComponent = DefaultRootComponent(
            homeComponentFactory = homeComponentFactory,
            componentContext = componentContext,
        )
    }
}
