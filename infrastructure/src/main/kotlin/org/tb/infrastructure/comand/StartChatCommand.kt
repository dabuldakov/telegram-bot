package org.tb.infrastructure.comand

import org.springframework.stereotype.Component

@Component
class StartChatCommand : ChatCommand {
    override fun msg(): String {
        return "Здарово заебал!"
    }

    override fun name() = "/start"
}