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
    @ColumnInfo(name = COLUMN_TEXT) val text: String,
    @ColumnInfo(name = COLUMN_TIMESTAMP) val timestamp: Long,
) {
    internal companion object {
        internal const val TABLE_NAME: String = "note"

        internal const val COLUMN_UID: String = "uid"
        internal const val COLUMN_TEXT: String = "text"
        internal const val COLUMN_TIMESTAMP: String = "timestamp"
    }
}
