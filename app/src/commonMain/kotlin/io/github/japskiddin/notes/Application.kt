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
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
        Children(
            stack = component.childStack,
            modifier = modifier,
            animation = stackAnimation(fade())
        ) {
            when (val child = it.instance) {
                is RootComponent.Child.Home -> HomeScreen(component = child.component)
            }
        }
    }
}
