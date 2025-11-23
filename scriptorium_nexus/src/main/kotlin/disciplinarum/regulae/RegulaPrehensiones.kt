package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.exceptio.regulae.FabricaExceptionumRegularum
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.REGULA_GENERUM_PREHENSIONIS

class RegulaPrehensiones(
    private val tribunal: RegulaTribunal,
    private val variantes: Set<NomenDisciplinae>
) {
    // Block grip type
    fun vetatPrehensiones() {
        variantes.forEach { nomen ->
            tribunal.registra(nomen) { d ->
                if (!d.prehensiones.isNullOrEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        nomen.valor,
                        "Prehensiones non permittitur pro: '${nomen.valor}'."
                    )
                }
            }
        }
    }

    // Block grip width
    fun vetatGenusPrehensionis() {
        variantes.forEach { nomen ->
            tribunal.registra(nomen) { d ->
                if (!d.generaPrehensiones.isNullOrEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        nomen.valor,
                        "Genera prehensionis non permittitur pro: '${nomen.valor}'."
                    )
                }
            }
        }
    }

    // Require grip type
    fun exigitPrehensiones(vararg statutus: String) {
        val statutusConjunctio = statutus.map { it.lowercase() }.toSet()

        if (statutusConjunctio.isEmpty()) {
            throw FabricaExceptionumRegularum.absentia(REGULA_GENERUM_PREHENSIONIS)
        }

        variantes.forEach { nomen ->
            tribunal.registra(nomen) { d ->
                val prehensiones = d.prehensiones
                if (prehensiones.isNullOrEmpty()) {
                    throw FabricaExceptionumRegularum.absentia(REGULA_GENERUM_PREHENSIONIS)
                }

                val nonPermissae = prehensiones
                    .map { it.nomen.valor.lowercase() }
                    .filter { it !in statutusConjunctio }

                if (nonPermissae.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        nomen.valor,
                        "Prehensiones: ${nonPermissae.joinToString()} non permittitur pro: '${d.disciplinae.nomen.valor}'."
                    )
                }
            }
        }
    }

    // Require grip width
    fun exigitGenusPrehensionis(vararg statutus: String) {
        val permissaeConjunctio = statutus.map { it.lowercase() }.toSet()

        if (permissaeConjunctio.isEmpty()) {
            throw FabricaExceptionumRegularum.absentia(REGULA_GENERUM_PREHENSIONIS)
        }

        variantes.forEach { nomen ->
            tribunal.registra(nomen) { d ->
                val genera = d.generaPrehensiones
                if (genera.isNullOrEmpty()) {
                    throw FabricaExceptionumRegularum.absentia(REGULA_GENERUM_PREHENSIONIS)
                }
                val nonPermissae = genera
                    .map { it.nomen.valor.lowercase() }
                    .filter { it !in permissaeConjunctio }

                if (nonPermissae.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        nomen.valor,
                        "Genera prehensionis non permittitur pro: '${d.disciplinae.nomen.valor}'. Debet esse: ${nonPermissae.joinToString()}."
                    )
                }
            }
        }
    }
}