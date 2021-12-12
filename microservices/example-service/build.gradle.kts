plugins {
    id("org.liquibase.gradle") version "2.1.0"
}


dependencies {
    implementation(project(":common"))
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa:${property("springBootVersion")}")
        implementation("org.springframework.boot:spring-boot-starter-oauth2-client:${property("springBootVersion")}")
        implementation("org.springframework.boot:spring-boot-starter-security:${property("springBootVersion")}")
        implementation("org.springframework.boot:spring-boot-starter-validation:${property("springBootVersion")}")
        implementation("org.springframework.boot:spring-boot-starter-web:${property("springBootVersion")}")
        developmentOnly("org.springframework.boot:spring-boot-devtools:${property("springBootVersion")}")
        implementation("org.liquibase:liquibase-core:${property("liquibaseVersion")}")
        runtimeOnly("org.postgresql:postgresql:42.3.1")
        testImplementation("org.springframework.boot:spring-boot-starter-test:${property("springBootVersion")}") {
            exclude(module = "junit")
            exclude(module = "mockito-core")
        }
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
        testImplementation("org.springframework.security:spring-security-test:5.5.1")
        testImplementation("com.ninja-squad:springmockk:3.0.1")
        testImplementation("org.testcontainers:junit-jupiter:1.16.2")
        testImplementation("org.testcontainers:postgresql:1.16.2")

        liquibaseRuntime("org.liquibase:liquibase-core:${property("liquibaseVersion")}")
        liquibaseRuntime("org.liquibase:liquibase-groovy-dsl:3.0.0")
        liquibaseRuntime("info.picocli:picocli:4.6.1")
        liquibaseRuntime("org.postgresql:postgresql:42.3.1")
        liquibaseRuntime("org.liquibase.ext:liquibase-hibernate5:3.6")
    }

    dependencyManagement {
        imports {
            mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
        }
    }
}

liquibase {
    activities.register("main") {
        this.arguments = mapOf(
            "logLevel" to "info",
            "changeLogFile" to "src/main/resources/liquibase/master.xml",
            "url" to "jdbc:postgresql://localhost:5432/example",
            "username" to "root",
            "password" to "root",
            "driver" to "org.postgresql.Driver",
            "referenceUrl" to "hibernate:spring:com.mew.boilerplate.example?dialect=org.hibernate.dialect.PostgreSQLDialect")
    }
}