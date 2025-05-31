package org.tb.infrastructure.comand

interface ChatCommand {
    fun msg(): String

    fun name(): String
}