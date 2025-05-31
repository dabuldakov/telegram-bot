package org.tb.infrastructure.comand

import org.springframework.stereotype.Component
import org.tb.infrastructure.service.ResourceReader

@Component
class EmperorChatCommand : ChatCommand {

    override fun msg() = lines.random()

    override fun name() = "/emperor"

    companion object {
        val lines: List<String> by lazy {
            ResourceReader.readLines("warhammer_frazes.txt")
        }
    }
}