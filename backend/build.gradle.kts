plugins {
    kotlin("jvm") version "1.3.71"
    kotlin("plugin.serialization") version "1.3.71"
    application
}

group = "jp.denx"
version = "0.0.1"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://dl.bintray.com/toliner/koses")
}

dependencies {

    val ktorVersion: String by rootProject
    val exposedVersion: String by rootProject
    val kotestVersion: String by rootProject

    implementation(kotlin("stdlib-jdk8"))

    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-auth:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-auth:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common:$ktorVersion")
    implementation("io.ktor:ktor-locations:$ktorVersion")
    implementation("io.ktor:ktor-server-sessions:$ktorVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")

    implementation("dev.toliner:koses-jdk:0.0.1")

    implementation("ch.qos.logback:logback-classic:1.2.3")

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    implementation("org.mariadb.jdbc:mariadb-java-client:2.5.4")
    implementation("com.zaxxer:HikariCP:3.3.0")

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation(kotlin("test-junit"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs += "-Xuse-experimental=kotlin.OptIn"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs += "-Xuse-experimental=kotlin.OptIn"
        }
    }
    test {
        useJUnitPlatform()
    }
    application {
        mainClassName = "io.ktor.server.netty.EngineMain"
    }
}