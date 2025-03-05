package io.github.japskiddin.notes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
