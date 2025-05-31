package org.tb.infrastructure.comand

import org.springframework.stereotype.Component

@Component
class EchoChatCommand : ChatCommand {
    override fun msg(): String {
        return "Echo ebat!"
    }

    override fun name(): String {
        return "/echo"
    }
}