package ars_disciplina.disciplinarum.regulae

import ars_disciplina.regularum.OmniRegulae
import org.example.commune.exemplaria.interfacia.ArchetypusDisciplinae
import org.example.commune.regulae.RegulaTribunal
import org.example.disciplinarum.regulae.regulaeArchetyporum

object RegistratorRegularumArchetyporum {

    fun registra(
        tribunal: RegulaTribunal,
        familia: ArchetypusDisciplinae
    ) {
        regulaeArchetyporum(tribunal, familia.disciplinae) {

            if (OmniRegulae.EXIGIT_VARIATIONES in familia.regulae) {
                exigitVariationes(
                    *familia.variationesPermissae
                        .map { it.nomen.valor }
                        .toTypedArray()
                )
            }

            if (OmniRegulae.EXIGIT_TRACTIONEM in familia.regulae) {
                exigitMotum(
                    familia.motusRequisitus.nomen.valor
                )
            }

            if (OmniRegulae.EXIGIT_PROPULSIONEM in familia.regulae) {
                exigitMotum(
                    familia.motusRequisitus.nomen.valor
                )
            }

            if (OmniRegulae.VETAT_ANGULUM in familia.regulae) {
                vetatAngulus()
            }

            if (OmniRegulae.EXIGIT_ANGULUM_NON_NEGATIVUM in familia.regulae) {
                exigitAngulumNonNegativum()
            }

            if (OmniRegulae.EXIGIT_ANGULOS_PERMISSOS in familia.regulae) {
                exigitAngulos(
                    *familia.angulusPermissae
                        .map { it.angulus.valor }
                        .toDoubleArray()
                )
            }

            if (OmniRegulae.EXIGIT_ANGULUM_MINIMUM in familia.regulae) {
                exigitAngulumMinimum(familia.angulusMinimum)
            }

            if (OmniRegulae.EXIGIT_PREHENSIONES in familia.regulae) {
                exigitPrehensiones(
                    *familia.prehensionesPermissae
                        .map { it.nomen.valor }
                        .toTypedArray())
            }

            if (OmniRegulae.EXIGIT_GENUS_PREHENSIONIS in familia.regulae) {
                exigitGenusPrehensionis(
                    *familia.generaPrehensionisPermissae
                        .map { it.nomen.valor }
                        .toTypedArray()
                )
            }

            if (OmniRegulae.EXIGIT_COMPOSITATEM in familia.regulae) {
                exigitCompositatem()
            }

            if (OmniRegulae.EXIGIT_BILATERALITATEM in familia.regulae) {
                exigitBilateralitatem()
            }

            if (OmniRegulae.EXIGIT_MODUM_EXTERNUM in familia.regulae) {
                exigitModumExternum()
            }
        }
    }
}