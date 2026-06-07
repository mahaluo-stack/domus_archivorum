package org.example.exemplaria.interfacies

import exceptio.valores.FabricaExceptionumValoris
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.CLASSIS_IGNOTA
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.DESCRIPTIO_MAXIMUS

interface InterfaciaDescriptio<T : Any> : InterfaciaValida {
    val descriptio: T

    fun valida() {
        require(descriptio.toString().length <= DESCRIPTIO_MAXIMUS) {
            throw FabricaExceptionumValoris.descriptioLonga(
                this::class.simpleName ?: CLASSIS_IGNOTA, DESCRIPTIO_MAXIMUS
            )
        }
    }
}