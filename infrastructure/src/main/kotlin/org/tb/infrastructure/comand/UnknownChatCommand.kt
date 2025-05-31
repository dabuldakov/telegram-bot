package org.tb.infrastructure.comand

import org.springframework.stereotype.Component

@Component
class UnknownChatCommand : ChatCommand {
    override fun msg() = "Костер видишь?"

    override fun name() = ""
}