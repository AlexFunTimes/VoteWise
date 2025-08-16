plugins {
    id("com.android.application") version "8.12.0" apply false
    id("org.jetbrains.kotlin.android") version "2.2.0" apply false // Assuming you meant 1.9.23 or similar, or 2.0.0 if you are using it
    id("com.google.devtools.ksp") version "2.2.0-2.0.2" apply false
    id("com.google.dagger.hilt.android") version "2.57" apply false
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}
