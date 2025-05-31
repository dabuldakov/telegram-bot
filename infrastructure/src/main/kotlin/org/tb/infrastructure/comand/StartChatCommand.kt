package org.tb.infrastructure.comand

import org.springframework.stereotype.Component

@Component
class StartChatCommand : ChatCommand {
    override fun msg(): String {
        return "Hello zaebal!"
    }

    override fun name(): String {
        return "/start"
    }
}