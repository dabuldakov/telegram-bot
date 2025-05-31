package org.tb.infrastructure.handler

import org.springframework.stereotype.Component
import org.tb.infrastructure.comand.ChatCommand
import org.tb.infrastructure.comand.UnknownChatCommand

@Component
class MessageHandlerImpl(
    chatCommands: List<ChatCommand>
): MessageHandler {
    private var factory: Map<String, ChatCommand> = chatCommands.associateBy { it.name() }

    override fun answer(messageText: String): String {
        return factory.getOrDefault(messageText, UnknownChatCommand()).msg()
    }
}