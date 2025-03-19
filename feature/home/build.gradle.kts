import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
}

kotlin {
    explicitApi = ExplicitApiMode.Strict

    jvmToolchain(21)

    androidTarget()
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(project.dependencies.platform(libs.androidx.compose.bom))
            implementation(projects.core.uikit)
            implementation(projects.core.domain)
            implementation(projects.core.data)
            implementation(libs.decompose)
            implementation(libs.decompose.extensions.compose)
            implementation(libs.koin.compose)
            implementation(compose.components.resources)
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
        }
    }
}

android {
    namespace = "io.github.japskiddin.notes.feature.home"

    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    buildFeatures {
        compose = true
    }

    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

dependencies {
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.tooling.preview)
}
