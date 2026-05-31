package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.exceptio.regulae.FabricaExceptionumRegularum
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.REGULA_ANGULORUM
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.REGULA_MOTUS
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.REGULA_VARIATIONUM
import org.example.commune.regulae.RegulaTribunal

class RegulaDisciplinae(
    private val tribunal: RegulaTribunal,
    private val variantes: Set<NomenDisciplinae>
) {
    fun exigitDisciplinaVariationes(vararg statutus: String) {
        val statutusConjunctio = statutus.map { it.lowercase() }.toSet()

        if (statutusConjunctio.isEmpty()) {
            throw FabricaExceptionumRegularum.absentia(REGULA_VARIATIONUM)
        }

        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                val nonPermissae = d.variationes
                    .map { it.nomen.valor.lowercase() }
                    .filter { it !in statutusConjunctio }

                if (nonPermissae.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_VARIATIONUM,
                        "Variationes non permittuntur: '${nonPermissae.joinToString()}'."
                    )
                }
            }
        }
    }

    fun exigitMotum(statutus: String) {
        val motusRequisitus = statutus.lowercase()

        if (motusRequisitus.isEmpty()) {
            throw FabricaExceptionumRegularum.absentia(REGULA_MOTUS)
        }

        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                if (motusRequisitus != d.motus.nomen.valor.lowercase()) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_MOTUS,
                        "Motus: '${motusRequisitus}' non permittitur pro: '${nomen.valor}'. Motus debet esse: '${d.motus.nomen.valor}'."
                    )
                }
            }
        }
    }

    fun vetatAngulum() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                if (!d.angulus.isNullOrEmpty()) {
                    throw FabricaExceptionumRegularum.absentia(REGULA_ANGULORUM)
                }
            }
        }
    }

    fun exigitAngulum() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                val realis = d.angulus
                if (realis.isNullOrEmpty()) {
                    throw FabricaExceptionumRegularum.absentia(REGULA_ANGULORUM)
                }
            }
        }
    }

    fun exigitAngulumNonNegativum() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                val realis = d.angulus

                if (realis.isNullOrEmpty()) {
                    throw FabricaExceptionumRegularum.absentia(
                        REGULA_ANGULORUM,
                    )
                }

                val negativi = realis.filter { it.angulus.valor < 0 }

                if (negativi.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_ANGULORUM,
                        "Angulus negativus non permittitur pro: '${nomen.valor}'. Angulus debet esse non negativus."
                    )
                }
            }
        }
    }
}