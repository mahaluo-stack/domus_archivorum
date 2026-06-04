package org.example.exemplaria.interfacies

import exceptio.valores.FabricaExceptionumValoris
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

interface InterfaciaCreatioTempus : InterfaciaValida {
    val tempus: LocalDateTime

    fun valida() {
        require(tempus <= Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())) {
            throw FabricaExceptionumValoris.tempusFuturum()
        }
    }
}