package io.github.japskiddin.notes

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(appModules)
    }

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Notes",
        ) {
            App()
        }
    }
}
