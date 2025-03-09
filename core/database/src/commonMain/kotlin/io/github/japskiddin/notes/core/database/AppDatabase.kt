package io.github.japskiddin.notes.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import io.github.japskiddin.notes.core.database.dao.NoteDao
import io.github.japskiddin.notes.core.database.dao.TaskDao
import io.github.japskiddin.notes.core.database.dao.TodoDao
import io.github.japskiddin.notes.core.database.entities.NoteDBO
import io.github.japskiddin.notes.core.database.entities.TaskDBO
import io.github.japskiddin.notes.core.database.entities.TodoDBO
import kotlinx.coroutines.Dispatchers

private const val DATABASE_VERSION: Int = 1
internal const val DATABASE_NAME = "database.db"

@Database(
    entities = [
        NoteDBO::class,
        TodoDBO::class,
        TaskDBO::class,
    ],
    version = DATABASE_VERSION
)
internal abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    abstract fun todoDao(): TodoDao

    abstract fun taskDao(): TaskDao
}

public class AppDatabase internal constructor(
    private val database: AppRoomDatabase
) {
    public val noteDao: NoteDao
        get() = database.noteDao()

    public val todoDao: TodoDao
        get() = database.todoDao()

    public val taskDao: TaskDao
        get() = database.taskDao()
}

internal fun AppDatabase(
    builder: RoomDatabase.Builder<AppRoomDatabase>
): AppDatabase {
    val roomDatabase = builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
    return AppDatabase(roomDatabase)
}
