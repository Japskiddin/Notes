package io.github.japskiddin.notes.core.model

public data class Task(
    val uid: Long,
    val todoUid: Long,
    val status: Int,
    val text: String,
)
