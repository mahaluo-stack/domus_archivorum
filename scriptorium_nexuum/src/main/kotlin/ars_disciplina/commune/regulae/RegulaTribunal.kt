package org.example.commune.regulae

import org.example.commune.exceptio.regulae.FabricaExceptionumRegularum
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.CAUSA_IGNOTA

class RegulaTribunal {

    private val tabulaRegulorum = mutableMapOf<String, MutableSet<(Any) -> Unit>>()

    fun <T : Any> registra(clavis: String, regula: (T) -> Unit) {
        val regulae = tabulaRegulorum
            .computeIfAbsent(clavis.lowercase()) { mutableSetOf() }

        @Suppress("UNCHECKED_CAST")
        regulae.add(regula as (Any) -> Unit)
    }

    fun <T : Any> valida(clavis: String, entia: T) {
        val regulae = tabulaRegulorum[clavis.lowercase()] ?: return

        for (regula in regulae) {
            try {
                @Suppress("UNCHECKED_CAST")
                (regula as (T) -> Unit).invoke(entia)

            } catch (e: Exception) {
                throw FabricaExceptionumRegularum.violatio(
                    nomenRegulae = clavis,
                    causa = e.message ?: CAUSA_IGNOTA
                )
            }
        }
    }
}