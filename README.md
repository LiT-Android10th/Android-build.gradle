# Android-build.gradle
build.gradleに立ち向かうメンター向けに作ったやつ

簡単に言えばプロジェクトをインストールするか、下の部分コピペしてくださいね。

ちなみにこれは脱出アプリなのでこのままインストールしちゃって引き継げばワンチャンある。

[Qiita](https://qiita.com/Nabe_LiT/private/85a61b1456e69ea530c5 "link Qiita")もどうぞ。





```
apply plugin: 'com.android.application'

android {
    compileSdkVersion 27
    buildToolsVersion '27.0.3'
    defaultConfig {
        applicationId "com.lifeistech.android.dasshutsu"
        minSdkVersion 19
        targetSdkVersion 25
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support.constraint:constraint-layout:1.1.2'
    androidTestImplementation('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    implementation 'com.android.support:appcompat-v7:27.1.1'
    implementation 'com.android.support:design:27.1.1'
    testImplementation 'junit:junit:4.12'
```
