import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    explicitApi = ExplicitApiMode.Strict

    jvmToolchain(21)

    androidTarget()
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(projects.core.domain)
            api(projects.core.model)
            implementation(projects.core.common)
            api(libs.androidx.lifecycle.runtime)
            api(libs.androidx.lifecycle.viewmodel)
            api(libs.koin.core.viewmodel)
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            api(libs.koin.android)
        }
    }
}

android {
    namespace = "io.github.japskiddin.notes.feature.home.ui_logic"

    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
