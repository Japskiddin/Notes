package io.github.japskiddin.notes.core.database.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Keep
@Entity(
    tableName = "task",
    foreignKeys = [
        ForeignKey(
            entity = TodoDBO::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("todo_uid"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
public data class TaskDBO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid") val uid: Long,
    @ColumnInfo(name = "todo_uid", index = true) val todoUid: Long,
    @ColumnInfo(name = "status") val status: Int,
    @ColumnInfo(name = "text") val text: String,
)
