plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
}

android {
    namespace = "com.heterogeneousgraph.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.heterogeneousgraph.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation("me.tatarka.inject:kotlin-inject-runtime:0.6.3")
    ksp("me.tatarka.inject:kotlin-inject-compiler-ksp:0.6.3")
}