package org.tb.infrastructure.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.tb.infrastructure.handler.MessageHandler
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

@Service
class Service(
    private val messageHandler: MessageHandler,
    @Value("\${bot.token}") private val botToken: String?,
    @Value("\${bot.name}")private val botName: String?
) : TelegramLongPollingBot(botToken){

    val logger: Logger = LoggerFactory.getLogger(Service::class.java)

    init {
        setCommands()
    }

    override fun getBotUsername(): String {
        return botName?: throw IllegalArgumentException("Can not get bot name from resources")
    }

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            sendMsg(
                chatId = update.message.chatId,
                message = messageHandler.answer(update.message.text)
            )
        }
    }

    private fun setCommands() {
        val commands = listOf(
            BotCommand("/start", "Say hello"),
            BotCommand("/help", "Get help"),
            BotCommand("/echo", "Echo"),
            BotCommand("/emperor", "Gain strength in moments of weakness"),
            BotCommand("/ip", "Get your IP")
        )
        execute(SetMyCommands(commands, null, null))
    }

    private fun sendMsg(chatId: Long, message: String) {
        val sendMessage = SendMessage(chatId.toString(), message)
        try {
            execute(sendMessage)
        } catch (e: TelegramApiException) {
            logger.error("Error sending message", e)
        }
    }
}