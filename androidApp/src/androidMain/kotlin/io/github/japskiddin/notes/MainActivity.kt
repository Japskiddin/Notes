package io.github.japskiddin.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
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
            Application(
                component = rootComponent,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
