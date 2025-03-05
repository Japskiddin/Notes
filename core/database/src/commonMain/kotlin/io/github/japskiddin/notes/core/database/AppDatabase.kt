package io.github.japskiddin.notes.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import io.github.japskiddin.notes.core.database.dao.NoteDao
import io.github.japskiddin.notes.core.database.entities.NoteDBO
import kotlinx.coroutines.Dispatchers

private const val DATABASE_VERSION: Int = 1
internal const val DATABASE_NAME = "database.db"

@Database(
    entities = [
        NoteDBO::class
    ],
    version = DATABASE_VERSION
)
internal abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}

public class AppDatabase internal constructor(
    private val database: AppRoomDatabase
) {
    public val noteDao: NoteDao
        get() = database.noteDao()
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
