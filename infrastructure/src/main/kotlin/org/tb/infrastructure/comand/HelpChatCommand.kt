package org.tb.infrastructure.comand

import org.springframework.stereotype.Component

@Component
class HelpChatCommand : ChatCommand {
    override fun msg(): String {
        return "Huly noesh!"
    }

    override fun name(): String {
        return "/help"
    }
}