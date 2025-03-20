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
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.stack.Children
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import io.github.japskiddin.notes.feature.home.component.ToolbarComponent
import io.github.japskiddin.notes.feature.home.model.BottomBarItem

@Composable
public fun HomeScreen(
    component: HomeComponent,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { ToolbarUi(component = component.toolbarComponent) },
        bottomBar = {
            BottomBarUi(
                items = listOf(
                    BottomBarItem.Notes,
                    BottomBarItem.Todo,
                )
            )
        }
    ) { paddingValues ->
        Children(
            stack = component.childStack
        ) { child ->
            when (child.instance) {
                is HomeComponent.HomeChild.Notes -> NotesUi()
                is HomeComponent.HomeChild.Todo -> TodoUi()
            }
        }
    }
}

@Composable
private fun NotesUi(
    modifier: Modifier = Modifier
) {
    Text(text = "Notes")
}

@Composable
private fun TodoUi(
    modifier: Modifier = Modifier
) {
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
    items: List<BottomBarItem>,
    modifier: Modifier = Modifier,
) {
    var selectedItem by remember {
        mutableStateOf(BottomBarItem.Notes)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .displayCutoutPadding(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items.forEach { item ->
            BottomBarButtonUi(
                item = item,
                isSelected = false,
            ) {
            }
        }
//        BottomBarButtonUi(
//            title = "Notes",
//            icon = Icons.Default.Notifications,
//            isSelected = false,
//        ) {
//        }
//        BottomBarButtonUi(
//            title = "Todo",
//            icon = Icons.AutoMirrored.Filled.List,
//            isSelected = false,
//        ) {
//        }
    }
}

@Composable
private fun BottomBarButtonUi(
    item: BottomBarItem,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clickable { onClick() }
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.title,
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = item.title
        )
    }
}
