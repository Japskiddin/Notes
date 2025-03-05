package io.github.japskiddin.notes.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import io.github.japskiddin.notes.core.database.dao.NoteDao
import io.github.japskiddin.notes.core.database.entities.NoteDBO
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module

private const val DATABASE_VERSION: Int = 1
internal const val DATABASE_NAME = "database.db"

@Database(
    entities = [
        NoteDBO::class
    ],
    version = DATABASE_VERSION
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}

internal fun AppDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase = builder.setDriver(BundledSQLiteDriver())
    .setQueryCoroutineContext(Dispatchers.IO)
    .build()

internal expect fun platformDatabaseModule(): Module
