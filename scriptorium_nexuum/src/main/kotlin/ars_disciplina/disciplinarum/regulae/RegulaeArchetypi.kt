package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.regulae.RegulaTribunal

fun regulaeArchetypi(
    tribunal: RegulaTribunal,
    variantes: Set<String>,
    block: RegulaeArchetypi.() -> Unit
) {
    RegulaeArchetypi(tribunal, variantes.map { NomenDisciplinae(it) }.toSet()).apply(block)
}

@DslMarker
annotation class RegulaeArchetypiDsl

@RegulaeArchetypiDsl
class RegulaeArchetypi(
    tribunal: RegulaTribunal,
    variantes: Set<NomenDisciplinae>
) {
    private val regulaDisciplinae = RegulaDisciplinae(tribunal, variantes)
    private val regulaPrehensiones = RegulaPrehensiones(tribunal, variantes)
    private val regulaClassificatio = RegulaClassificatio(tribunal, variantes)

    fun exigitVariationes(vararg statutus: String) = regulaDisciplinae.exigitVariationes(*statutus)
    fun exigitMotum(statutus: String) = regulaDisciplinae.exigitMotum(statutus)
    fun exigitCompositatem() = regulaClassificatio.exigitCompositatem()
    fun exigitIsolationem() = regulaClassificatio.exigitIsolationem()

    fun exigitAngulumNonNegativum() = regulaDisciplinae.exigitAngulumNonNegativum()
    fun exigitAngulos(vararg anguli: Double) = regulaDisciplinae.exigitAngulos(*anguli)
    fun exigitAngulumMinimum(minimum: Double) = regulaDisciplinae.exigitAngulumMinimum(minimum)

    fun exigitPrehensiones(vararg statutus: String) = regulaPrehensiones.exigitPrehensiones(*statutus)
    fun exigitGenusPrehensionis(vararg statutus: String) = regulaPrehensiones.exigitGenusPrehensionis(*statutus)

    fun exigitLaterales() = regulaClassificatio.exigitLaterales()
    fun exigitUnilateralitatem() = regulaClassificatio.exigitUnilateralitatem()
    fun exigitBilateralitatem() = regulaClassificatio.exigitBilateralitatem()

    fun exigitModusOneris() = regulaClassificatio.exigitModusOneris()
    fun exigitModumExternum() = regulaClassificatio.exigitModumExternum()
    fun exigitModumCorporis() = regulaClassificatio.exigitModumCorporis()

    fun vetatPrehensiones() = regulaPrehensiones.vetatPrehensiones()
    fun vetatGenusPrehenionis() = regulaPrehensiones.vetatGenusPrehensionis()
    fun vetatAngulum() = regulaDisciplinae.vetatAngulum()
}
