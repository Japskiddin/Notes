package io.github.japskiddin.notes

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import io.github.japskiddin.notes.component.RootComponent
import io.github.japskiddin.notes.feature.home.HomeScreen

@Composable
fun Application(
    component: RootComponent,
    modifier: Modifier = Modifier,
) {
    MaterialTheme {
        Children(
            stack = component.stack,
            modifier = modifier,
            animation = stackAnimation(fade())
        ) {
            when (val child = it.instance) {
                is RootComponent.Child.Home -> HomeScreen(component = child.component)
            }
        }
    }
}
