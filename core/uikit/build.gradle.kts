import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    explicitApi = ExplicitApiMode.Strict

    jvmToolchain(libs.versions.jvm.get().toInt())

    androidLibrary {
        namespace = "io.github.japskiddin.notes.core.uikit"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }

        // TOOD: найти, как теперь это подключается
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
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
        }

        androidMain.dependencies {
            implementation(compose.preview)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "io.github.japskiddin.resources"
    generateResClass = always
}
