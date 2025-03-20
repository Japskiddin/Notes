package io.github.japskiddin.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import io.github.japskiddin.notes.component.RootComponent
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val rootComponentFactory: RootComponent.Factory by inject()
        val rootComponent = rootComponentFactory(defaultComponentContext())

        setContent {
            Application(component = rootComponent)
        }
    }
}
