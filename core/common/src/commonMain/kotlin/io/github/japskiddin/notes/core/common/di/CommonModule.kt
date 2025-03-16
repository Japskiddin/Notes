package io.github.japskiddin.notes.core.common.di

import io.github.japskiddin.notes.core.common.AppDispatchers
import org.koin.core.module.Module
import org.koin.dsl.module

public val commonModule: Module
    get() = module {
        loggerModule()

        single { AppDispatchers() }
    }
