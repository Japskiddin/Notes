package io.github.japskiddin.notes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import io.github.japskiddin.notes.component.RootComponent
import io.github.japskiddin.notes.di.appModules
import io.github.japskiddin.notes.utils.runOnUiThread
import io.github.japskiddin.resources.Res
import io.github.japskiddin.resources.app_name
import org.jetbrains.compose.resources.stringResource
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.inject

fun main() {
    startKoin {
        modules(appModules)
    }

    val lifecycle = LifecycleRegistry()

    val rootComponentFactory: RootComponent.Factory by inject(RootComponent.Factory::class.java)
    val rootComponent = runOnUiThread {
        rootComponentFactory(
            componentContext = DefaultComponentContext(lifecycle),
        )
    }

    application {
        val windowState = rememberWindowState()

        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = stringResource(Res.string.app_name),
        ) {
            LifecycleController(
                lifecycleRegistry = lifecycle,
                windowState = windowState,
                windowInfo = LocalWindowInfo.current
            )

            Application(
                component = rootComponent,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
