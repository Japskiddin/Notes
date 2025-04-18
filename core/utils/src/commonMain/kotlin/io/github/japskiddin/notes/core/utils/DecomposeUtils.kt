package io.github.japskiddin.notes.core.utils

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

public fun ComponentContext.componentCoroutineScope(dispatcher: CoroutineDispatcher): CoroutineScope {
    val scope = CoroutineScope(SupervisorJob() + dispatcher)

    lifecycle.doOnDestroy {
        scope.cancel()
    }

    return scope
}
