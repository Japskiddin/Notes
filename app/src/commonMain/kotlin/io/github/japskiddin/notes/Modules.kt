package io.github.japskiddin.notes

import io.github.japskiddin.notes.core.database.databaseModule
import org.koin.core.module.Module

private val coreModules: List<Module>
    get() = listOf(
        databaseModule
    )

val appModules: List<Module>
    get() = listOf(
        coreModules
    ).flatten()
