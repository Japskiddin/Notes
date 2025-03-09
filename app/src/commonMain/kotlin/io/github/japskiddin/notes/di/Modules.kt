package io.github.japskiddin.notes.di

import io.github.japskiddin.notes.core.data.di.repositoryModule
import io.github.japskiddin.notes.core.database.di.databaseModule
import org.koin.core.module.Module

private val coreModules: List<Module>
    get() = listOf(
        databaseModule,
        repositoryModule,
    )

val appModules: List<Module>
    get() = listOf(
        coreModules,
    ).flatten()
