import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.android.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    explicitApi = ExplicitApiMode.Strict

    jvmToolchain(libs.versions.jvm.get().toInt())

    androidLibrary {
        namespace = "io.github.japskiddin.notes.feature.home"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }

//        buildFeatures {
//            compose = true
//        }

//        dependencies {
//            debugImplementation(compose.uiTooling)
//        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.components.resources)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.decompose)
            implementation(libs.decompose.extensions.compose)
            implementation(libs.koin.compose)
            implementation(projects.core.common)
            implementation(projects.core.utils)
            implementation(projects.core.uikit)
            implementation(projects.core.domain)
            implementation(projects.core.data)
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(compose.preview)
        }
    }
}
