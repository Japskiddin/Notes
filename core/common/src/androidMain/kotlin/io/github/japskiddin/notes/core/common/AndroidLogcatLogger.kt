package io.github.japskiddin.notes.core.common

import android.util.Log

internal class AndroidLogcatLogger : Logger {
    override fun d(
        tag: String,
        message: String
    ) {
        Log.d(tag, message)
    }

    override fun e(
        tag: String,
        message: String
    ) {
        Log.e(tag, message)
    }
}
