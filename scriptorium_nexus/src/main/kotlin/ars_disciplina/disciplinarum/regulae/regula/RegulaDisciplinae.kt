package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.EntiaDisciplina
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
    fun exigitVariationes(vararg statutus: String) {
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
                if (d.angulus.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.absentia(REGULA_ANGULORUM)
                }
            }
        }
    }

    fun exigitAngulum() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                val realis = d.angulus
                if (realis.isEmpty()) {
                    throw FabricaExceptionumRegularum.absentia(REGULA_ANGULORUM)
                }
            }
        }
    }

    fun exigitAngulumNonNegativum() {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(nomen.valor.lowercase()) { d ->
                val realis = d.angulus

                if (realis.isEmpty()) {
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

    fun exigitAngulumMinimum(minimum: Double) {
        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(
                nomen.valor.lowercase()
            ) { d ->

                val invalidae = d.angulus.filter {
                    it.angulus.valor < minimum
                }

                if (invalidae.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_ANGULORUM,
                        "Angulus debet esse maior quam $minimum."
                    )
                }
            }
        }
    }

    fun exigitAngulos(vararg anguliPermissi: Double) {

        val permissi = anguliPermissi.toSet()

        if (permissi.isEmpty()) {
            throw FabricaExceptionumRegularum.absentia(
                REGULA_ANGULORUM
            )
        }

        variantes.forEach { nomen ->
            tribunal.registra<EntiaDisciplina>(
                nomen.valor.lowercase()
            ) { d ->

                val realis = d.angulus

                if (realis.isEmpty()) {
                    throw FabricaExceptionumRegularum.absentia(
                        REGULA_ANGULORUM
                    )
                }

                val nonPermissi = realis.filter {
                    it.angulus.valor !in permissi
                }

                if (nonPermissi.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        REGULA_ANGULORUM,
                        "Anguli non permittuntur pro: '${nomen.valor}'."
                    )
                }
            }
        }
    }
}