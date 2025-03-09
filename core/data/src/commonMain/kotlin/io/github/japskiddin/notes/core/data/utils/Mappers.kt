package io.github.japskiddin.notes.core.data.utils

import io.github.japskiddin.notes.core.database.entities.NoteDBO
import io.github.japskiddin.notes.core.database.entities.TaskDBO
import io.github.japskiddin.notes.core.database.entities.TodoDBO
import io.github.japskiddin.notes.core.model.Note
import io.github.japskiddin.notes.core.model.Task
import io.github.japskiddin.notes.core.model.Todo

internal fun NoteDBO.toNote(): Note =
    Note(
        uid = this.uid,
        title = this.title,
        text = this.text,
        pinned = this.pinned,
        createTime = this.createTime,
        editTime = this.editTime,
        category = this.category,
    )

internal fun TaskDBO.toTask(): Task =
    Task(
        uid = this.uid,
        todoUid = this.todoUid,
        status = this.status,
        text = this.text,
    )

internal fun TodoDBO.toTodo(): Todo =
    Todo(
        uid = this.uid,
        title = this.title,
        description = this.description,
        pinned = this.pinned,
        createTime = this.createTime,
        editTime = this.editTime,
        category = this.category,
    )
