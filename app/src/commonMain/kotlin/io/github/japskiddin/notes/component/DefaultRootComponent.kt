package io.github.japskiddin.notes.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import io.github.japskiddin.notes.component.DefaultRootComponent.ChildConfig.Home
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext,
    private val homeComponentFactory: HomeComponent.Factory,
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<ChildConfig>()

    override val childStack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = Home,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild,
    )

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext,
    ): RootComponent.Child = when (config) {
        is Home -> RootComponent.Child.Home(
            homeComponentFactory(componentContext)
        )
    }

    @Serializable
    private sealed interface ChildConfig {
        @Serializable
        data object Home : ChildConfig
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
