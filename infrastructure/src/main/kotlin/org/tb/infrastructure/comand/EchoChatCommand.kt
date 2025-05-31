package org.tb.infrastructure.comand

import org.springframework.stereotype.Component

@Component
class EchoChatCommand : ChatCommand {
    override fun msg(): String {
        return "Эхо ебать!"
    }

    override fun name() = "/echo"
}