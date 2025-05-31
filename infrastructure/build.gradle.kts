plugins {
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:${property("springBootVersion")}")
    implementation("org.telegram:telegrambots:${property("telegramBotApiVersion")}")
}