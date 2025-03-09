package io.github.japskiddin.notes.core.database.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.japskiddin.notes.core.database.AppDatabase
import io.github.japskiddin.notes.core.database.AppRoomDatabase
import io.github.japskiddin.notes.core.database.DATABASE_NAME
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual fun platformDatabaseModule(): Module =
    module(createdAtStart = true) {
        single<AppDatabase> {
            val builder = getDatabaseBuilder(get())
            AppDatabase(builder)
        }
    }

private fun getDatabaseBuilder(
    context: Context,
): RoomDatabase.Builder<AppRoomDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder<AppRoomDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
    )
}
