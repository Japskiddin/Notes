package io.github.japskiddin.notes.core.database.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Keep
@Entity(
    tableName = TodoDBO.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = TodoListDBO::class,
            parentColumns = arrayOf(TodoListDBO.COLUMN_UID),
            childColumns = arrayOf(TodoDBO.COLUMN_LIST_UID),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
public data class TodoDBO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_UID) val uid: Long,
    @ColumnInfo(name = COLUMN_LIST_UID) val listUid: Long,
    @ColumnInfo(name = COLUMN_STATUS) val status: Int,
    @ColumnInfo(name = COLUMN_TEXT) val text: String,
) {
    internal companion object {
        internal const val TABLE_NAME: String = "todo"

        internal const val COLUMN_UID: String = "uid"
        internal const val COLUMN_LIST_UID: String = "list_uid"
        internal const val COLUMN_STATUS: String = "status"
        internal const val COLUMN_TEXT: String = "text"
    }
}
