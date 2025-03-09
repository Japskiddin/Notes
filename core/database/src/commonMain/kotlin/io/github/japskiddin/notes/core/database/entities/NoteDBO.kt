package io.github.japskiddin.notes.core.database.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(
    tableName = NoteDBO.TABLE_NAME
)
public data class NoteDBO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_UID) val uid: Long,
    @ColumnInfo(name = COLUMN_TITLE) val title: String,
    @ColumnInfo(name = COLUMN_TEXT) val text: String,
    @ColumnInfo(name = COLUMN_TIMESTAMP) val timestamp: Long,
    @ColumnInfo(name = COLUMN_PINNED) val pinned: Boolean,
    @ColumnInfo(name = COLUMN_CREATE_TIME) val createTime: Long,
    @ColumnInfo(name = COLUMN_EDIT_TIME) val editTime: Long,
    @ColumnInfo(name = COLUMN_CATEGORY) val category: String
) {
    internal companion object {
        internal const val TABLE_NAME: String = "note"

        internal const val COLUMN_UID: String = "uid"
        internal const val COLUMN_TITLE: String = "title"
        internal const val COLUMN_TEXT: String = "text"
        internal const val COLUMN_TIMESTAMP: String = "timestamp"
        internal const val COLUMN_PINNED: String = "pinned"
        internal const val COLUMN_CREATE_TIME: String = "create_time"
        internal const val COLUMN_EDIT_TIME: String = "edit_time"
        internal const val COLUMN_CATEGORY: String = "category"
    }
}
