import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.multiplatform.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidx.room)
}

room {
    schemaDirectory("$projectDir/schemas")
}

kotlin {
    explicitApi = ExplicitApiMode.Strict

    jvmToolchain(libs.versions.jvm.get().toInt())

    androidLibrary {
        namespace = "io.github.japskiddin.notes.core.database"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        // TODO: Найти, как указывать теперь consumer rules
//        consumerProguardFiles("consumer-rules.pro")

        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.androidx.room.runtime)
            implementation(libs.androidx.sqlite.bundled)
            implementation(libs.androidx.sqlite)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.coroutines.core)
        }
    }
}

dependencies {
    add("kspAndroid", libs.androidx.room.compiler)
    add("kspJvm", libs.androidx.room.compiler)
}
