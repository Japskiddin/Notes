package io.github.japskiddin.notes.core.common.di

import io.github.japskiddin.notes.core.common.AppConfiguration
import io.github.japskiddin.notes.core.common.JvmConfiguration
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual fun configurationModule(): Module =
    module {
        factory<AppConfiguration> {
            JvmConfiguration()
        }
    }
