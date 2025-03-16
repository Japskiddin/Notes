package io.github.japskiddin.notes

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import io.github.japskiddin.notes.feature.home.ui.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun MainScreen() {
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
        HomeScreen()
    }
}
