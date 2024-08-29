plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.olamap"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.olamap"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    //OlaMap SDK
    implementation(files("libs/maps.aar"))
    //Required for OlaMap SDK
//    implementation(libs.play.services.location)
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    implementation ("com.moengage:moe-android-sdk:12.6.01")
    implementation ("org.maplibre.gl:android-sdk:10.2.0")
    implementation ("org.maplibre.gl:android-sdk-directions-models:5.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation ("com.google.maps.android:android-maps-utils:2.3.0")


    implementation ("com.moengage:moe-android-sdk:12.6.01")
    implementation ("org.maplibre.gl:android-sdk-services:5.9.0")
    implementation ("org.maplibre.gl:android-sdk-turf:5.9.0")
    implementation ("org.maplibre.gl:android-plugin-markerview-v9:1.0.0")
    implementation ("org.maplibre.gl:android-plugin-annotation-v9:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.0.0")
    implementation ("androidx.lifecycle:lifecycle-compiler:2.0.0")
    //    implementation(libs.play.services.location)
//    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
//    implementation ("com.moengage:moe-android-sdk:12.6.01")
//    implementation ("org.maplibre.gl:android-sdk:10.2.0")
//    implementation ("org.maplibre.gl:android-sdk-directions-models:5.9.0")
//    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")
//    implementation ("com.google.maps.android:android-maps-utils:2.3.0")
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}