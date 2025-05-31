package org.tb.infrastructure.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.tb.infrastructure.handler.MessageHandler
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

@Service
class Service(
    private val messageHandler: MessageHandler,
    @Value("\${bot.token}") botToken: String?
) : TelegramLongPollingBot(botToken){

    val logger: Logger = LoggerFactory.getLogger(Service::class.java)

    override fun getBotUsername(): String {
        return "ochen_hueviy_bot"
    }

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            sendMsg(
                chatId = update.message.chatId,
                message = messageHandler.answer(update.message.text)
            )
        }
    }

    protected fun sendMsg(chatId: Long, message: String) {
        val sendMessage = SendMessage(chatId.toString(), message)
        try {
            execute(sendMessage)
        } catch (e: TelegramApiException) {
            logger.error("Error sending message", e)
        }
    }
}