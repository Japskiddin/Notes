import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    dependencies {
        implementation(projects.shared)

        implementation(libs.compose.components.resources)

        implementation(compose.desktop.currentOs)
        implementation(libs.kotlinx.coroutines.swing)

        implementation(platform(libs.koin.bom))
        implementation(libs.koin.core)
        implementation(libs.koin.compose)
    }
}

compose.desktop {
    application {
        mainClass = "io.github.japskiddin.notes.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "io.github.japskiddin.notes"
            packageVersion = libs.versions.app.versionName.get()
        }
    }
}
