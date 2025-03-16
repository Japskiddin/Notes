package io.github.japskiddin.notes.feature.home.uiLogic

import androidx.lifecycle.ViewModel
import io.github.japskiddin.notes.feature.home.uiLogic.usecase.GetAllNotesUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

public class HomeViewModel internal constructor() : ViewModel(), KoinComponent {
    private val getAllNotesUseCase: GetAllNotesUseCase by inject()
}
