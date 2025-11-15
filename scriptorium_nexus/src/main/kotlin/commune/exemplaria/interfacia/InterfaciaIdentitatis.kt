package org.example.exemplaria.interfacies

import exceptio.valores.FabricaExceptionumValoris

interface InterfaciaIdentitatis : InterfaciaValida {
    val identitas: Int

    fun valida() {
        require(identitas > 0) {
            throw FabricaExceptionumValoris.valorInvalidus(nomenClassis, identitas)
        }
    }
}