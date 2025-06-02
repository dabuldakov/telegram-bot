package org.tb.infrastructure.comand

import org.springframework.stereotype.Component
import java.net.URI

private const val HTTPS_API_IPIFY_ORG = "https://api.ipify.org"

@Component
class HostIPCommand() : ChatCommand {
    override fun msg(): String {
        return "Мой IP: ${getPublicIP()}"
    }

    override fun name(): String {
        return "/ip"
    }

    private fun getPublicIP(): String = try {
        URI(HTTPS_API_IPIFY_ORG).toURL()
            .openStream()
            .bufferedReader()
            .use { it.readText() }
    } catch (e: Exception) {
        "Не удалось получить IP (${e.message})"
    }
}