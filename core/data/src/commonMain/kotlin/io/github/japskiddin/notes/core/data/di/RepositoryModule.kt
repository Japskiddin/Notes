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
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

public val repositoryModule: Module = module {
    factoryOf(::NoteDataSourceImpl) { bind<NoteDataSource>() }
    factoryOf(::NoteRepositoryImpl) { bind<NoteRepository>() }
    factoryOf(::TaskDataSourceImpl) { bind<TaskDataSource>() }
    factoryOf(::TaskRepositoryImpl) { bind<TaskRepository>() }
    factoryOf(::TodoDataSourceImpl) { bind<TodoDataSource>() }
    factoryOf(::TodoRepositoryImpl) { bind<TodoRepository>() }
}
