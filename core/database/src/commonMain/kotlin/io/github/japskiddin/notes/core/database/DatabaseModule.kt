package io.github.japskiddin.notes.core.database

import io.github.japskiddin.notes.core.database.dao.NoteDao
import io.github.japskiddin.notes.core.database.dao.TodoDao
import org.koin.core.module.Module

public val databaseModule: Module
    get() = platformDatabaseModule()
        .apply {
            single<NoteDao> { get<AppDatabase>().noteDao }
            single<TodoDao> { get<AppDatabase>().todoDao }
        }
