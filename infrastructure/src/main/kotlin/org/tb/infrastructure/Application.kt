package org.tb.infrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(scanBasePackages = ["org.tb"])
internal class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}