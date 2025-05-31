package org.tb.infrastructure.handler

interface MessageHandler {
    fun answer(messageText: String): String
}