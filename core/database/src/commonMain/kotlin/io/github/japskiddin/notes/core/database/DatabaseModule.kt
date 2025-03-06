package io.github.japskiddin.notes.core.database

import io.github.japskiddin.notes.core.database.dao.NoteDao
import org.koin.core.module.Module

public val databaseModule: Module
    get() = platformDatabaseModule()
        .apply {
            single<NoteDao> { get<AppDatabase>().noteDao }
        }
