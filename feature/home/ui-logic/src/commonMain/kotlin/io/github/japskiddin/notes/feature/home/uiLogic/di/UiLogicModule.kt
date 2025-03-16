package io.github.japskiddin.notes.feature.home.uiLogic.di

import io.github.japskiddin.notes.feature.home.uiLogic.HomeViewModel
import io.github.japskiddin.notes.feature.home.uiLogic.usecase.GetAllNotesUseCase
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

public val featureHomeUiLogicModule: Module =
    module {
        factoryOf(::GetAllNotesUseCase)

        viewModelOf(::HomeViewModel)
    }
