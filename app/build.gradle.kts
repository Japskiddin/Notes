import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import java.io.FileInputStream
import java.util.*

plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
}

kotlin {
    jvmToolchain(21)

    androidTarget()
    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(project.dependencies.platform(libs.androidx.compose.bom))
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.decompose)
            implementation(libs.decompose.extensions.compose)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(projects.core.common)
            implementation(projects.core.model)
            implementation(projects.core.domain)
            implementation(projects.core.database)
            implementation(projects.core.data)
            implementation(projects.feature.home)
        }

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.koin.androidx.navigation)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "io.github.japskiddin.notes"

    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "io.github.japskiddin.notes"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = libs.versions.app.versionCode.get().toInt()
        versionName = libs.versions.app.versionName.get()
        setProperty("archivesBaseName", "notes-$versionName-$versionCode")
        ndk {
            //noinspection ChromeOsAbiSupport
            abiFilters += listOf("arm64-v8a", "armeabi-v7a", "x86", "x86_64")
        }
    }

    androidResources {
        @Suppress("UnstableApiUsage")
        generateLocaleConfig = true
    }

    val keysRepo: String = if (project.hasProperty("Keys.repo")) {
        project.property("Keys.repo") as String
    } else {
        ""
    }
    val keystoreProperties: Properties? = if (keysRepo.isNotBlank()) {
        val projectPropsFile = file("$keysRepo/google-play-publish.properties")
        if (projectPropsFile.exists()) {
            Properties().apply {
                load(FileInputStream(projectPropsFile))
            }
        } else {
            null
        }
    } else {
        null
    }
    val secretProperties = Properties().apply {
        if (keystoreProperties != null) {
            setProperty(
                "SIGNING_KEYSTORE_PATH",
                file(keysRepo + keystoreProperties["RELEASE_STORE_FILE"]).path
            )
            setProperty(
                "SIGNING_KEYSTORE_PASSWORD",
                keystoreProperties["RELEASE_STORE_PASS"].toString()
            )
            setProperty("SIGNING_KEY_ALIAS", keystoreProperties["RELEASE_KEY_ALIAS"].toString())
            setProperty("SIGNING_KEY_PASSWORD", keystoreProperties["RELEASE_KEY_PASS"].toString())
        } else {
            setProperty(
                "SIGNING_KEYSTORE_PATH",
                file("../keys/android-signing-keystore.jks").path
            )
            setProperty(
                "SIGNING_KEYSTORE_PASSWORD",
                System.getenv("SIGNING_KEYSTORE_PASSWORD")
            )
            setProperty("SIGNING_KEY_ALIAS", System.getenv("SIGNING_KEY_ALIAS"))
            setProperty("SIGNING_KEY_PASSWORD", System.getenv("SIGNING_KEY_PASSWORD"))
        }
    }
    val releaseSigning = signingConfigs.create("release") {
        storeFile = file(secretProperties["SIGNING_KEYSTORE_PATH"] as String)
        keyAlias = secretProperties["SIGNING_KEY_ALIAS"] as String
        storePassword = secretProperties["SIGNING_KEYSTORE_PASSWORD"] as String
        keyPassword = secretProperties["SIGNING_KEY_PASSWORD"] as String
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        release {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = releaseSigning
        }
        debug {
            versionNameSuffix = " DEBUG"
            signingConfig = releaseSigning
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    bundle {
        language {
            @Suppress("UnstableApiUsage")
            enableSplit = false
        }
    }

    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }

    applicationVariants.all {
        val variant = this
        variant.outputs
            .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                val outputFileName =
                    "notes-${variant.versionName}-${variant.versionCode}-${buildType.name}.apk"
                output.outputFileName = outputFileName
            }
    }

    dependencies {
        debugImplementation(compose.uiTooling)
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
