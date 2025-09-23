@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.japskiddin.notes.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import io.github.japskiddin.notes.feature.home.component.BottomBarComponent
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import io.github.japskiddin.notes.feature.home.component.NotesComponent
import io.github.japskiddin.notes.feature.home.component.TodoComponent
import io.github.japskiddin.notes.feature.home.component.TopBarComponent
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
        modifier = modifier,
        topBar = {
            TopBarUi(
                component = component.topBarComponent,
                title = when (activeChild) {
                    is HomeComponent.Child.Notes -> stringResource(Res.string.menu_notes)
                    is HomeComponent.Child.Todo -> stringResource(Res.string.menu_todo)
                }
            )
        },
        bottomBar = {
            BottomBarUi(
                component = component.bottomBarComponent,
                activeChild = activeChild,
            )
        }
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
private fun TopBarUi(
    component: TopBarComponent,
    title: String,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            actionIconContentColor = MaterialTheme.colorScheme.onSurface,
        ),
        actions = {
            IconButton(
                onClick = { component.onSettingsClick() },
            ) {
                Icon(
                    imageVector = vectorResource(Res.drawable.ic_settings),
                    contentDescription = stringResource(Res.string.settings),
                )
            }
        }
    )
}

@Composable
private fun BottomBarUi(
    component: BottomBarComponent,
    activeChild: HomeComponent.Child,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .displayCutoutPadding(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BottomBarButton(
            icon = vectorResource(Res.drawable.ic_notes),
            title = stringResource(Res.string.menu_notes),
            isSelected = activeChild is HomeComponent.Child.Notes,
        ) {
            component.onNotesClick()
        }
        BottomBarButton(
            icon = vectorResource(Res.drawable.ic_todo_list),
            title = stringResource(Res.string.menu_todo),
            isSelected = activeChild is HomeComponent.Child.Todo,
        ) {
            component.onTodoClick()
        }
    }
}

@Composable
private fun BottomBarButton(
    icon: ImageVector,
    title: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val iconModifier = Modifier
        .size(height = 36.dp, width = 64.dp)
        .then(
            if (isSelected) {
                Modifier.background(
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .2f),
                    shape = MaterialTheme.shapes.large
                )
            } else {
                Modifier
            }
        )
        .padding(6.dp)

    Column(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick() }
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = iconModifier,
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}
