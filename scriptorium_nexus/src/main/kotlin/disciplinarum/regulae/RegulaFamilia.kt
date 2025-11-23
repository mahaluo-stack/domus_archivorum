package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.valores.NomenDisciplinae

fun regulaFamilia(
    tribunal: RegulaTribunal,
    variantes: Set<String>,
    block: RegulaFamilia.() -> Unit
) {
    RegulaFamilia(tribunal, variantes.map { NomenDisciplinae(it) }.toSet()).apply(block)
}

@DslMarker
annotation class RegulaDsl

@RegulaDsl
class RegulaFamilia(
    tribunal: RegulaTribunal,
    variantes: Set<NomenDisciplinae>
) {

    private val regulaDisciplinae = RegulaDisciplinae(tribunal, variantes)
    private val regulaPrehensiones = RegulaPrehensiones(tribunal, variantes)
    private val regulaClassificatio = RegulaClassificatio(tribunal, variantes)

    fun exigitDisciplinaVariationes(vararg statutus: String) = regulaDisciplinae.exigitDisciplinaVariationes(*statutus)
    fun exigitMotum(statutus: String) = regulaDisciplinae.exigitMotum(statutus)
    fun vetatAngulus() = regulaDisciplinae.vetatAngulum()

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
