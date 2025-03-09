package io.github.japskiddin.notes.core.model

public data class Note(
    val uid: Long,
    val title: String,
    val text: String,
    val pinned: Boolean,
    val createTime: Long,
    val editTime: Long,
    val category: String
)
