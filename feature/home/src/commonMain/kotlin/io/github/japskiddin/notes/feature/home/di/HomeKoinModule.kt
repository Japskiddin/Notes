package io.github.japskiddin.notes.feature.home.di

import io.github.japskiddin.notes.feature.home.component.DefaultHomeComponent
import io.github.japskiddin.notes.feature.home.component.HomeComponent
import org.koin.core.module.Module
import org.koin.dsl.module

public val componentHomeModule: Module =
    module {
        single<HomeComponent.Factory> { DefaultHomeComponent.Factory() }
    }
