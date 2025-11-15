package org.example.exemplaria.interfacies

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import exceptio.valores.FabricaExceptionumValoris

interface InterfaciaCreatioTempus : InterfaciaValida {
    val tempus: LocalDateTime

    fun valida() {
        require(tempus <= Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())) {
            throw FabricaExceptionumValoris.tempusFuturum()
        }
    }
}