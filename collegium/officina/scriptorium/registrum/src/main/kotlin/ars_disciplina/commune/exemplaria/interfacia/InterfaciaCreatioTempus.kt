package org.example.exemplaria.interfacies

import exceptio.valores.FabricaExceptionumValoris
import java.time.LocalDateTime

interface InterfaciaCreatioTempus : InterfaciaValida {
    val tempus: LocalDateTime

    fun valida() {
        require(tempus <= LocalDateTime.now()) {
            throw FabricaExceptionumValoris.tempusFuturum()
        }
    }
}