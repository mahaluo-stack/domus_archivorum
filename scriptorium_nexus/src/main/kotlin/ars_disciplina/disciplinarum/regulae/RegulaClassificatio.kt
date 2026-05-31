package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.exceptio.regulae.FabricaExceptionumRegularum
import org.example.commune.exemplaria.constantia.ConstantiaClassificationum.GENUS_COMPOUND
import org.example.commune.exemplaria.constantia.ConstantiaClassificationum.GENUS_ISOLATION
import org.example.commune.exemplaria.constantia.ConstantiaClassificationum.LATERALIS_BILATERAL
import org.example.commune.exemplaria.constantia.ConstantiaClassificationum.LATERALIS_UNILATERAL
import org.example.commune.exemplaria.constantia.ConstantiaClassificationum.MODUS_ONERIS_BODYWEIGHT
import org.example.commune.exemplaria.constantia.ConstantiaClassificationum.MODUS_ONERIS_EXTERNAL_LOAD
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.REGULA_GENERUM_DISCIPLINAE
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.REGULA_LATERALIS
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.REGULA_MODUS_ONERIS
import org.example.commune.regulae.RegulaTribunal

class RegulaClassificatio(
    private val tribunal: RegulaTribunal,
    private val variantes: Set<NomenDisciplinae>
) {
    // Require compound exercise
    fun exigitCompositatem() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                if (d.generaDisciplinae.nomen.valor.lowercase() != GENUS_COMPOUND) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_GENERUM_DISCIPLINAE,
                        "Genus disciplinae pro: '${nomen.valor}' debet esse: '${GENUS_COMPOUND}'."
                    )
                }
            }
        }
    }

    // Require isolation exercise
    fun exigitIsolationem() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                if (d.generaDisciplinae.nomen.valor.lowercase() != GENUS_ISOLATION) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_GENERUM_DISCIPLINAE,
                        "Genus disciplinae pro: '${nomen.valor}' debet esse: '$GENUS_ISOLATION'."
                    )
                }
            }
        }
    }

    // Require unilateral exercise
    fun exigitUnilateralitatem() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                if (d.lateralis.none { it.nomen.valor.lowercase() == LATERALIS_UNILATERAL }) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_LATERALIS,
                        "Lateralis pro: '${nomen.valor}' debet esse: '${LATERALIS_UNILATERAL}'."
                    )
                }
            }
        }
    }

    // Require bilateral exercise
    fun exigitBilateralitatem() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                if (d.lateralis.none { it.nomen.valor.lowercase() == LATERALIS_BILATERAL }) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_LATERALIS,
                        "Lateralis pro: '${nomen.valor}' debet esse: '${LATERALIS_BILATERAL}'."
                    )
                }
            }
        }
    }

    // Require bilateral or unilateral, or both
    fun exigitLaterales(vararg statutus: String) {
        val statutusConjunctio = statutus.map { it.lowercase() }.toSet()

        if (statutusConjunctio.isEmpty()) {
            throw FabricaExceptionumRegularum.absentia(REGULA_LATERALIS)
        }

        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                val realis = d.lateralis
                    .map { it.nomen.valor.lowercase() }
                    .toSet()
                val invalidae = realis - statutusConjunctio
                if (invalidae.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_LATERALIS,
                        "Lateralis: '${invalidae.joinToString()}' non permittitur pro: '${nomen.valor}'."
                    )
                }
            }
        }
    }

    // Require external load
    fun exigitModumExternum() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                val inventa = d.modusOneris
                    .any { it.nomen.valor.lowercase() == MODUS_ONERIS_EXTERNAL_LOAD }
                if (!inventa) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_MODUS_ONERIS,
                        "Modus oneris pro: '${nomen.valor}' debet esse: '${MODUS_ONERIS_EXTERNAL_LOAD}'."
                    )
                }
            }
        }
    }

    // Require bodyweight
    fun exigitModumCorporis() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                val inventa = d.modusOneris
                    .any { it.nomen.valor.lowercase() == MODUS_ONERIS_BODYWEIGHT }
                if (!inventa) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_MODUS_ONERIS,
                        "Modus oneris pro: '${nomen.valor}' debet esse: '${MODUS_ONERIS_BODYWEIGHT}'."
                    )
                }
            }
        }
    }

    // Require external load or bodyweight, or both
    fun exigitModosOneris(vararg statutus: String) {
        val statutusConjunctio = statutus.map { it.lowercase() }.toSet()

        if (statutusConjunctio.isEmpty()) {
            throw FabricaExceptionumRegularum.absentia(REGULA_MODUS_ONERIS)
        }

        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                val realis = d.modusOneris.map { it.nomen.valor.lowercase() }.toSet()
                val invalidae = realis - statutusConjunctio

                if (invalidae.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_MODUS_ONERIS,
                        "Modus oneris: '${invalidae.joinToString()}' non permittitur pro: '${nomen.valor}'"
                    )
                }
            }
        }
    }
}
