package io.github.japskiddin.notes.core.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher

public class AppDispatchers(
    public val default: CoroutineDispatcher = Dispatchers.Default,
    public val io: CoroutineDispatcher = Dispatchers.IO,
    public val main: MainCoroutineDispatcher = Dispatchers.Main,
    public val mainImmediate: MainCoroutineDispatcher = Dispatchers.Main.immediate,
    public val unconfined: CoroutineDispatcher = Dispatchers.Unconfined
)
