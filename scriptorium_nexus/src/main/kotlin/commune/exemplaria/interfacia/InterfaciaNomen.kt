package org.example.exemplaria.interfacies

import exceptio.valores.FabricaExceptionumValoris
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.NOMEN_MAXIMUS
import kotlin.reflect.full.memberProperties

interface InterfaciaNomen<T : Any> : InterfaciaValida {
    val nomen: T

    fun valida() {
        val textum: String = try {
            val proprietas = nomen::class.memberProperties.first()
            val valor = proprietas.call(nomen)
            valor as? String ?: throw FabricaExceptionumValoris.valorInvalidus(
                nomen::class.simpleName ?: ConstantiaExceptionum.CLASSIS_DESCRIPTIO,
                valor ?: ConstantiaExceptionum.NULLUS
            )
        } catch (e: Exception) {
            throw FabricaExceptionumValoris.valorInvalidus(
                nomen::class.simpleName ?: ConstantiaExceptionum.CLASSIS_DESCRIPTIO,
                nomen
            )
        }
        require(textum.length <= NOMEN_MAXIMUS) {
            throw FabricaExceptionumValoris.nomenLongum(
                this::class.simpleName ?: ConstantiaExceptionum.CLASSIS_IGNOTA,
                NOMEN_MAXIMUS
            )
        }
    }
}