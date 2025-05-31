package org.tb.infrastructure.comand

import org.springframework.stereotype.Component

@Component
class UnknownChatCommand : ChatCommand {
    override fun msg(): String {
        return "Koster vidish?"
    }

    override fun name(): String {
        return ""
    }
}