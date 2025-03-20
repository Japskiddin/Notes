package io.github.japskiddin.notes.feature.home.component

import com.arkivanov.decompose.ComponentContext

internal class DefaultTodoComponent(
    componentContext: ComponentContext
) : TodoComponent, ComponentContext by componentContext
