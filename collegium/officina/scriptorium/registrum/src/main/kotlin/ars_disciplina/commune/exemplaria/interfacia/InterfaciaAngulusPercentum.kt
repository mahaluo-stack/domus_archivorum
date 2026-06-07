package org.example.exemplaria.interfacies

import exceptio.valores.FabricaExceptionumValoris
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.ANGULUS_MAXIMUS
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.ANGULUS_MINIMUS

interface InterfaciaAngulusPercentum : InterfaciaValida {
    val percentum: Double

    fun valida() {
        require(percentum in ANGULUS_MINIMUS..ANGULUS_MAXIMUS) {
            throw FabricaExceptionumValoris.angulusPercentum(nomenClassis, percentum)
        }
    }
}