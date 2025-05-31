package org.tb.infrastructure.initializer

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.tb.infrastructure.service.Service
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Component
class BotInitializer(
    private val bot: Service
) {
    private val log: Logger = LoggerFactory.getLogger(BotInitializer::class.java)

    @EventListener(ContextRefreshedEvent::class)
    fun init() {
        try {
            val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
            telegramBotsApi.registerBot(bot)
        } catch (e: TelegramApiException) {
            log.error(e.message, e)
        }
    }
}