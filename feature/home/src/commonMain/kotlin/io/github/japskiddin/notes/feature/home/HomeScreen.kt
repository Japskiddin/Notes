package io.github.japskiddin.notes.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import io.github.japskiddin.notes.feature.home.component.NotesComponent
import io.github.japskiddin.notes.feature.home.component.TodoComponent
import io.github.japskiddin.notes.feature.home.component.ToolbarComponent
import io.github.japskiddin.resources.Res
import io.github.japskiddin.resources.menu_notes
import io.github.japskiddin.resources.menu_todo
import org.jetbrains.compose.resources.stringResource

@Composable
public fun HomeScreen(
    component: HomeComponent,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { ToolbarUi(component = component.toolbarComponent) },
        bottomBar = { BottomBarUi(component = component) }
    ) { paddingValues ->
        Children(
            stack = component.stack,
            modifier = Modifier.padding(paddingValues),
            animation = stackAnimation(fade()),
        ) {
            when (val child = it.instance) {
                is HomeComponent.Child.Notes -> NotesUi(component = child.component)
                is HomeComponent.Child.Todo -> TodoUi(component = child.component)
            }
        }
    }
}

@Composable
private fun NotesUi(
    component: NotesComponent,
    modifier: Modifier = Modifier,
) {
    val list by component.list.collectAsState()

    if (list.isNotEmpty()) {
        Text(text = "Notes")
    } else {
        Text(text = "Empty")
    }
}

@Composable
private fun TodoUi(
    component: TodoComponent,
    modifier: Modifier = Modifier,
) {
    val list by component.list.collectAsState()

    Text(text = "Todo")
}

@Composable
private fun ToolbarUi(
    component: ToolbarComponent,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .displayCutoutPadding()
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
    ) {
        IconButton(
            onClick = { component.onSettingsClick() },
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                modifier = Modifier.size(24.dp),
            )
        }
    }
}

@Composable
private fun BottomBarUi(
    component: HomeComponent,
    modifier: Modifier = Modifier,
) {
    val stack by component.stack.subscribeAsState()
    val activeComponent = stack.active.instance

    Row(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .displayCutoutPadding(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BottomBarButton(
            modifier = Modifier.clickable {
                component.onNotesClick()
            },
            icon = Icons.Default.Create,
            title = stringResource(Res.string.menu_notes),
            isSelected = activeComponent is HomeComponent.Child.Notes,
        )
        BottomBarButton(
            modifier = Modifier.clickable {
                component.onTodoClick()
            },
            icon = Icons.Default.Home,
            title = stringResource(Res.string.menu_todo),
            isSelected = activeComponent is HomeComponent.Child.Todo,
        )
    }
}

@Composable
private fun BottomBarButton(
    isSelected: Boolean,
    icon: ImageVector,
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = title
        )
    }
}
