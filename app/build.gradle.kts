import org.gradle.kotlin.dsl.android

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.tms_android"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.tms_android"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        getByName("main") {
            res.srcDirs(
                "src/main/res",
                "src/main/res-lessons/lesson16",
                "src/main/res-lessons/lesson17",
                "src/main/res-lessons/lesson18",
                "src/main/res-lessons/lesson19"
            )
        }
    }
}

android {
    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}