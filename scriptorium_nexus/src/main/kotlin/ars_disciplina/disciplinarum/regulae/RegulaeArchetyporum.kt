package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.regulae.RegulaTribunal

fun regulaeArchetyporum(
    tribunal: RegulaTribunal,
    variantes: Set<String>,
    block: RegulaeArchetyporum.() -> Unit
) {
    RegulaeArchetyporum(tribunal, variantes.map { NomenDisciplinae(it) }.toSet()).apply(block)
}

@DslMarker
annotation class RegulaeArchetyporumDsl

@RegulaeArchetyporumDsl
class RegulaeArchetyporum(
    tribunal: RegulaTribunal,
    variantes: Set<NomenDisciplinae>
) {
    private val regulaDisciplinae = RegulaDisciplinae(tribunal, variantes)
    private val regulaPrehensiones = RegulaPrehensiones(tribunal, variantes)
    private val regulaClassificatio = RegulaClassificatio(tribunal, variantes)

    fun exigitVariationes(vararg statutus: String) = regulaDisciplinae.exigitVariationes(*statutus)
    fun exigitMotum(statutus: String) = regulaDisciplinae.exigitMotum(statutus)
    fun vetatAngulus() = regulaDisciplinae.vetatAngulum()
    fun exigitAngulus() = regulaDisciplinae.exigitAngulum()
    fun exigitAngulumNonNegativum() = regulaDisciplinae.exigitAngulumNonNegativum()
    fun exigitAngulos(vararg anguli: Double) = regulaDisciplinae.exigitAngulos(*anguli)
    fun exigitAngulumMinimum(minimum: Double) = regulaDisciplinae.exigitAngulumMinimum(minimum)

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
    fun exigitModosOneris() = regulaClassificatio.exigitModusOneris()
}
