package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.regulae.RegulaTribunal


fun regulaExercitatio(
    tribunal: RegulaTribunal,
    nomen: String,
    block: RegulaExercitatio.() -> Unit
) {
    RegulaExercitatio(tribunal, NomenDisciplinae(nomen)).apply(block)
}

@DslMarker
annotation class RegulaExercitatioDsl

@RegulaExercitatioDsl
class RegulaExercitatio(
    tribunal: RegulaTribunal,
    nomen: NomenDisciplinae
) {
    private val regulaDisciplinae = RegulaDisciplinae(tribunal, setOf(nomen))
    private val regulaPrehensiones = RegulaPrehensiones(tribunal, setOf(nomen))
    private val regulaClassificatio = RegulaClassificatio(tribunal, setOf(nomen))

    fun exigitDisciplinaVariationes(vararg statutus: String) = regulaDisciplinae.exigitDisciplinaVariationes(*statutus)
    fun exigitMotum(statutus: String) = regulaDisciplinae.exigitMotum(statutus)
    fun vetatAngulum() = regulaDisciplinae.vetatAngulum()
    fun exigitAngulum() = regulaDisciplinae.exigitAngulum()
    fun exigitAngulumNonNegativum() = regulaDisciplinae.exigitAngulumNonNegativum()

    fun vetatPrehensiones() = regulaPrehensiones.vetatPrehensiones()
    fun vetatGenusPrehenionis() = regulaPrehensiones.vetatGenusPrehensionis()
    fun exigitPrehensiones(vararg statutus: String) = regulaPrehensiones.exigitPrehensiones(*statutus)
    fun exigitGenusPrehensionis(vararg statutus: String) = regulaPrehensiones.exigitGenusPrehensionis(*statutus)

    fun exigitCompositatem() = regulaClassificatio.exigitCompositatem()
    fun exigitIsolationem() = regulaClassificatio.exigitIsolationem()

    fun exigitUnilateralitatem() = regulaClassificatio.exigitUnilateralitatem()
    fun exigitBilateralitatem() = regulaClassificatio.exigitBilateralitatem()
    fun exigitLaterales() = regulaClassificatio.exigitLaterales()

    fun exigitModumExternum() = regulaClassificatio.exigitModumExternum()
    fun exigitModumCorporis() = regulaClassificatio.exigitModumCorporis()
    fun exigitModosOneris() = regulaClassificatio.exigitModosOneris()
}