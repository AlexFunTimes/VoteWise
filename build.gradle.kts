plugins {
    id("com.android.application") version "8.12.0" apply false
    id("org.jetbrains.kotlin.android") version "2.2.0" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("androidx.room") version "2.7.2" apply false
    id("com.google.devtools.ksp") version "2.2.0-2.0.2" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
    id("com.google.android.gms.oss-licenses-plugin") version "0.10.6" apply false  // Added version for resolution
}

tasks.register("clean", Delete::class) {
    delete(layout.buildDirectory)
}