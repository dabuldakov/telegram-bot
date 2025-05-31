val jvmVersion = 21
val javaVersion = JavaVersion.VERSION_21

plugins {
    kotlin("jvm")
    kotlin("kapt")
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")

    java.sourceCompatibility = javaVersion

    repositories {
        mavenLocal()
        maven { url = uri("https://nexus.gts.rus.socgen/repository/maven-public") }
        gradlePluginPortal()
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
    }

    kotlin {
        jvmToolchain(jvmVersion)
        compilerOptions {
            freeCompilerArgs.addAll(
                "-Xjsr305=strict",
                "-Xjvm-default=all",
            )
        }
    }
}