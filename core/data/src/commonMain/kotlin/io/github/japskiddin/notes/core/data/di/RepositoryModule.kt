package io.github.japskiddin.notes.core.data.di

import io.github.japskiddin.notes.core.data.NoteDataSourceImpl
import io.github.japskiddin.notes.core.data.NoteRepositoryImpl
import io.github.japskiddin.notes.core.data.TaskDataSourceImpl
import io.github.japskiddin.notes.core.data.TaskRepositoryImpl
import io.github.japskiddin.notes.core.data.TodoDataSourceImpl
import io.github.japskiddin.notes.core.data.TodoRepositoryImpl
import io.github.japskiddin.notes.core.domain.NoteDataSource
import io.github.japskiddin.notes.core.domain.NoteRepository
import io.github.japskiddin.notes.core.domain.TaskDataSource
import io.github.japskiddin.notes.core.domain.TaskRepository
import io.github.japskiddin.notes.core.domain.TodoDataSource
import io.github.japskiddin.notes.core.domain.TodoRepository
import org.koin.core.module.Module
import org.koin.dsl.module

public val repositoryModule: Module = module {
    factory<NoteDataSource> { NoteDataSourceImpl(get()) }
    factory<NoteRepository> { NoteRepositoryImpl(get()) }
    factory<TaskDataSource> { TaskDataSourceImpl(get()) }
    factory<TaskRepository> { TaskRepositoryImpl(get()) }
    factory<TodoDataSource> { TodoDataSourceImpl(get()) }
    factory<TodoRepository> { TodoRepositoryImpl(get()) }
}
