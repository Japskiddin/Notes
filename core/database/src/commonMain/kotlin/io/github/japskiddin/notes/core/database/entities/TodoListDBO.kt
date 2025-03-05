package io.github.japskiddin.notes.core.database.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(
    tableName = TodoListDBO.TABLE_NAME
)
public data class TodoListDBO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_UID) val uid: Long,
    @ColumnInfo(name = COLUMN_DESCRIPTION) val description: String,
    @ColumnInfo(name = COLUMN_TIMESTAMP) val timestamp: Long,
    @ColumnInfo(name = COLUMN_LIST) val list: List<TodoDBO>,
) {
    internal companion object {
        internal const val TABLE_NAME: String = "todo_list"

        internal const val COLUMN_UID: String = "uid"
        internal const val COLUMN_DESCRIPTION: String = "description"
        internal const val COLUMN_TIMESTAMP: String = "timestamp"
        internal const val COLUMN_LIST: String = "list"
    }
}
