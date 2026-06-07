package ars_disciplina.commune

import org.example.commune.exceptio.regulae.FabricaExceptionumRegularum
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum

class RegulaTribunal<K, T> {

    private val regulae = mutableMapOf<K, MutableSet<(T) -> Unit>>()

    fun registra(clavis: K, regula: (T) -> Unit) {
        val regulae = regulae.computeIfAbsent(clavis) { mutableSetOf() }

        regulae.add(regula)
    }

    fun valida(clavis: K, entia: T) {
        val regulae = regulae[clavis] ?: return
        for (regula in regulae) {
            try {
                regula(entia)
            } catch (e: Exception) {
                throw FabricaExceptionumRegularum.violatio(
                    nomenRegulae = clavis.toString(),
                    causa = e.message ?: ConstantiaExceptionum.CAUSA_IGNOTA
                )
            }
        }
    }
}