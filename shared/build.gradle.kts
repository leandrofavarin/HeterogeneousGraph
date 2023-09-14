plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("app.cash.sqldelight") version "2.0.0"
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("me.tatarka.inject:kotlin-inject-runtime:0.6.3")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api("app.cash.sqldelight:android-driver:2.0.0")
            }
        }
        val iosMain by getting {
            dependencies {
                api("app.cash.sqldelight:native-driver:2.0.0")
            }
        }
    }
}

android {
    namespace = "com.heterogeneousgraph"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

sqldelight {
    databases {
        create("MyDatabase") {
            packageName.set("com.example")
        }
    }
}

dependencies {
    add("kspIosX64", "me.tatarka.inject:kotlin-inject-compiler-ksp:0.6.3")
    add("kspIosArm64", "me.tatarka.inject:kotlin-inject-compiler-ksp:0.6.3")
    add("kspIosSimulatorArm64", "me.tatarka.inject:kotlin-inject-compiler-ksp:0.6.3")
}
