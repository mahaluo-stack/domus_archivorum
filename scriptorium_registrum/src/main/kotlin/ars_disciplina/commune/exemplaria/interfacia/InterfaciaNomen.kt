package org.example.exemplaria.interfacies

import exceptio.valores.FabricaExceptionumValoris
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.CLASSIS_IGNOTA
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.DESCRIPTIO_MAXIMUS
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.NOMEN_MAXIMUS

interface InterfaciaNomen<T : Any> : InterfaciaValida {
    val nomen: T

    fun valida() {
        require(nomen.toString().length <= DESCRIPTIO_MAXIMUS) {
            throw FabricaExceptionumValoris.nomenLongum(
                this::class.simpleName ?: CLASSIS_IGNOTA, NOMEN_MAXIMUS
            )
        }
    }
}