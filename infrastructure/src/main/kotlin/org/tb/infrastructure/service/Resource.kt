package org.tb.infrastructure.service

import java.io.InputStreamReader

object ResourceReader {
    fun readLines(resourcePath: String): List<String> {
        return InputStreamReader(
            this::class.java.classLoader.getResourceAsStream(resourcePath)
                ?: throw IllegalArgumentException("Resource not found: $resourcePath")
        ).use { reader ->
            reader.readLines()
        }
    }
}