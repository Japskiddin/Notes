package io.github.japskiddin.notes.core.database.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Keep
@Entity(
    tableName = TaskDBO.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = TodoDBO::class,
            parentColumns = arrayOf(TodoDBO.COLUMN_UID),
            childColumns = arrayOf(TaskDBO.COLUMN_TODO_UID),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
public data class TaskDBO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_UID) val uid: Long,
    @ColumnInfo(name = COLUMN_TODO_UID) val todoUid: Long,
    @ColumnInfo(name = COLUMN_STATUS) val status: Int,
    @ColumnInfo(name = COLUMN_TEXT) val text: String,
) {
    internal companion object {
        internal const val TABLE_NAME: String = "task"

        internal const val COLUMN_UID: String = "uid"
        internal const val COLUMN_TODO_UID: String = "todo_uid"
        internal const val COLUMN_STATUS: String = "status"
        internal const val COLUMN_TEXT: String = "text"
    }
}
