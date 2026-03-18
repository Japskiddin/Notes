import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    androidLibrary {
        namespace = "io.github.japskiddin.notes.shared"

        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }

        androidResources {
            enable = true
        }

        withHostTest {
            isIncludeAndroidResources = true
        }
    }

    jvm("desktop")

    dependencies {
        implementation(libs.compose.runtime)
        implementation(libs.compose.foundation)
        implementation(libs.compose.material3)
        implementation(libs.compose.ui)
        implementation(libs.compose.components.resources)
        implementation(libs.compose.ui.tooling.preview)

        api(libs.decompose)
        api(libs.decompose.extensions.compose)

        implementation(libs.androidx.lifecycle.viewmodel.compose)
        implementation(libs.androidx.lifecycle.runtime.compose)

        implementation(libs.kotlinx.serialization.json)

        implementation(platform(libs.koin.bom))
        implementation(libs.koin.core)
        implementation(libs.koin.compose)

        implementation(projects.core.common)
        implementation(projects.core.model)
        implementation(projects.core.domain)
        implementation(projects.core.database)
        implementation(projects.core.data)
        api(projects.core.uikit)

        implementation(projects.feature.home)
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.ui.tooling)
}
