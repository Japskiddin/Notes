package io.github.japskiddin.notes.core.common.di

import io.github.japskiddin.notes.core.common.AndroidLogcatLogger
import io.github.japskiddin.notes.core.common.Logger
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal actual fun loggerModule(): Module =
    module {
        factoryOf<Logger>(::AndroidLogcatLogger)
    }
