package io.github.japskiddin.notes.core.model

public data class Todo(
    val uid: Long,
    val title: String,
    val description: String,
    val timestamp: Long,
    val pinned: Boolean,
    val createTime: Long,
    val editTime: Long,
    val category: String
)
