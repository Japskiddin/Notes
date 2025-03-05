package io.github.japskiddin.notes.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import java.io.File

internal actual fun platformDatabaseModule(): Module =
    module(createdAtStart = true) {
        single<AppDatabase> {
            val builder = getDatabaseBuilder()
            AppDatabase(builder)
        }
    }

private fun getDatabaseBuilder(): RoomDatabase.Builder<AppRoomDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), DATABASE_NAME)
    return Room.databaseBuilder<AppRoomDatabase>(
        name = dbFile.absolutePath,
    )
}
