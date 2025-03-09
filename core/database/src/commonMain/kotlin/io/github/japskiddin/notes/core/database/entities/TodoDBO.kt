package io.github.japskiddin.notes.core.database.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(
    tableName = "todo"
)
public data class TodoDBO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid") val uid: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "pinned") val pinned: Boolean,
    @ColumnInfo(name = "create_time") val createTime: Long,
    @ColumnInfo(name = "edit_time") val editTime: Long,
    @ColumnInfo(name = "category") val category: String
)
