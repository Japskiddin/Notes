package io.github.japskiddin.notes.core.common.di

import io.github.japskiddin.notes.core.common.AndroidConfiguration
import io.github.japskiddin.notes.core.common.AppConfiguration
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal actual fun configurationModule(): Module =
    module {
        factoryOf<AppConfiguration>(::AndroidConfiguration)
    }
