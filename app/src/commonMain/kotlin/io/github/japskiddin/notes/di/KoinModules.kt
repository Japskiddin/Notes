package io.github.japskiddin.notes.di

import io.github.japskiddin.notes.core.common.di.commonModule
import io.github.japskiddin.notes.core.data.di.repositoryModule
import io.github.japskiddin.notes.core.database.di.databaseModule
import io.github.japskiddin.notes.feature.home.uiLogic.di.featureHomeUiLogicModule
import org.koin.core.module.Module

private val coreModules: List<Module>
    get() = listOf(
        commonModule,
        databaseModule,
        repositoryModule,
    )

private val featureModules: List<Module>
    get() = listOf(
        featureHomeUiLogicModule,
    )

val appModules: List<Module>
    get() = listOf(
        coreModules,
        featureModules,
    ).flatten()
