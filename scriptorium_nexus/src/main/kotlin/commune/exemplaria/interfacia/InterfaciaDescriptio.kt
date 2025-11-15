package org.example.exemplaria.interfacies

import exceptio.valores.FabricaExceptionumValoris
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.CLASSIS_DESCRIPTIO
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.CLASSIS_IGNOTA
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.DESCRIPTIO_MAXIMUS
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.NULLUS
import kotlin.reflect.full.memberProperties

interface InterfaciaDescriptio<T : Any> : InterfaciaValida {
    val descriptio: T

    fun valida() {
        val textum: String = try {
            val proprietas = descriptio::class.memberProperties.first()
            val valor = proprietas.call(descriptio)
            valor as? String ?: throw FabricaExceptionumValoris.valorInvalidus(
                descriptio::class.simpleName ?: CLASSIS_DESCRIPTIO,
                valor ?: NULLUS
            )
        } catch (e: Exception) {
            throw FabricaExceptionumValoris.valorInvalidus(
                descriptio::class.simpleName ?: CLASSIS_DESCRIPTIO,
                descriptio
            )
        }
        require(textum.length <= DESCRIPTIO_MAXIMUS) {
            throw FabricaExceptionumValoris.descriptioLonga(
                this::class.simpleName ?: CLASSIS_IGNOTA,
                DESCRIPTIO_MAXIMUS
            )
        }
    }
}