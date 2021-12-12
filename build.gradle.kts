import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

java.sourceCompatibility = JavaVersion.VERSION_17

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.springframework.boot") version "2.6.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.6.0"
    kotlin("plugin.jpa") version "1.6.0"
    kotlin("kapt") version "1.6.0"
}

allprojects {
    extra["testcontainersVersion"] = "1.16.2"
    extra["springBootVersion"] = "2.6.1"
    extra["liquibaseVersion"] = "4.6.1"

    group = "com.mew.boilerplate"
    version = "0.0.1-SNAPSHOT"

    apply {
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.jetbrains.kotlin.plugin.jpa")
        plugin("kotlin-noarg")
        plugin("kotlin-kapt")
    }

    dependencies {
        kapt("org.mapstruct:mapstruct-processor:1.4.2.Final")
        api("javax.xml.bind:jaxb-api")
        api("jakarta.xml.bind:jakarta.xml.bind-api")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.mapstruct:mapstruct:1.4.2.Final")
    }



    repositories {
        mavenCentral()
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
