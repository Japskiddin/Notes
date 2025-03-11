package io.github.japskiddin.notes.core.database.di

import io.github.japskiddin.notes.core.database.AppDatabase
import io.github.japskiddin.notes.core.database.dao.NoteDao
import io.github.japskiddin.notes.core.database.dao.TaskDao
import io.github.japskiddin.notes.core.database.dao.TodoDao
import org.koin.core.module.Module
import org.koin.dsl.module

public val databaseModule: Module
    get() = module {
        platformDatabaseModule()
        single<NoteDao> { get<AppDatabase>().noteDao }
        single<TodoDao> { get<AppDatabase>().todoDao }
        single<TaskDao> { get<AppDatabase>().taskDao }
    }
