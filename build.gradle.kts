import com.deezer.caupain.model.StabilityLevelPolicy
import com.deezer.caupain.plugin.DependenciesUpdateTask

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.dependency.analysis) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.multiplatform.library) apply false
    alias(libs.plugins.compose.multiplatform) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.androidx.room) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.caupain)
}

buildscript {
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.ksp.gradle.plugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(layout.buildDirectory)
}

tasks.withType<DependenciesUpdateTask> {
    selectIf(StabilityLevelPolicy)
}
