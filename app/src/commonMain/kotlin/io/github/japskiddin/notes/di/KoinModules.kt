package io.github.japskiddin.notes.di

import io.github.japskiddin.notes.component.DefaultRootComponent
import io.github.japskiddin.notes.component.RootComponent
import io.github.japskiddin.notes.core.common.di.commonModule
import io.github.japskiddin.notes.core.data.di.repositoryModule
import io.github.japskiddin.notes.core.database.di.databaseModule
import io.github.japskiddin.notes.feature.home.di.componentHomeModule
import org.koin.core.module.Module
import org.koin.dsl.module

private val coreModules: List<Module>
    get() = listOf(
        commonModule,
        databaseModule,
        repositoryModule,
    )

private val rootComponentModule: Module =
    module {
        single<RootComponent.Factory> { DefaultRootComponent.Factory(get()) }
    }

private val componentModules: List<Module>
    get() = listOf(
        componentHomeModule,
        rootComponentModule,
    )

val appModules: List<Module>
    get() = listOf(
        coreModules,
        componentModules,
    ).flatten()
