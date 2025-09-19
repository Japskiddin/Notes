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
import io.github.japskiddin.resources.ic_notes
import io.github.japskiddin.resources.ic_settings
import io.github.japskiddin.resources.ic_todo_list
import io.github.japskiddin.resources.menu_notes
import io.github.japskiddin.resources.menu_todo
import io.github.japskiddin.resources.settings
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
public fun HomeScreen(
    component: HomeComponent,
    modifier: Modifier = Modifier,
) {
    val stack = component.stack.subscribeAsState()
    val activeChild = stack.value.active.instance

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ToolbarUi(
                component = component.toolbarComponent,
                title = when (activeChild) {
                    is HomeComponent.Child.Notes -> stringResource(Res.string.menu_notes)
                    is HomeComponent.Child.Todo -> stringResource(Res.string.menu_todo)
                }
            )
        },
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
}

@Composable
private fun TodoUi(
    component: TodoComponent,
    modifier: Modifier = Modifier,
) {
    val list by component.list.collectAsState()
}

@Composable
private fun ToolbarUi(
    component: ToolbarComponent,
    title: String,
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
        Text(
            text = title
        )
        IconButton(
            onClick = { component.onSettingsClick() },
        ) {
            Icon(
                imageVector = vectorResource(Res.drawable.ic_settings),
                contentDescription = stringResource(Res.string.settings),
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
            icon = vectorResource(Res.drawable.ic_notes),
            title = stringResource(Res.string.menu_notes),
            isSelected = activeComponent is HomeComponent.Child.Notes,
        )
        BottomBarButton(
            modifier = Modifier.clickable {
                component.onTodoClick()
            },
            icon = vectorResource(Res.drawable.ic_todo_list),
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
