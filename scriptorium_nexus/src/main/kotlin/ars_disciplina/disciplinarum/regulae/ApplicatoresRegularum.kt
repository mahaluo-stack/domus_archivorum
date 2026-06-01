package ars_disciplina.disciplinarum.regulae

import ars_disciplina.regularum.OmniRegulae
import org.example.commune.exemplaria.interfacia.ArchetypusDisciplinae
import org.example.disciplinarum.regulae.RegulaeArchetyporum

typealias ApplicatorRegulae = RegulaeArchetyporum.(ArchetypusDisciplinae) -> Unit

object ApplicatoresRegularum {
    val omnes = mapOf<OmniRegulae, ApplicatorRegulae>(
        OmniRegulae.EXIGIT_VARIATIONES to { archetypus ->
            exigitVariationes(
                *archetypus.variationesPermissae
                    .map { it.nomen.valor }
                    .toTypedArray()
            )
        },
        OmniRegulae.EXIGIT_TRACTIONEM to { archetypus ->
            exigitMotum(
                archetypus.motusRequisitus.nomen.valor
            )
        },
        OmniRegulae.EXIGIT_PROPULSIONEM to { archetypus ->
            exigitMotum(
                archetypus.motusRequisitus.nomen.valor
            )
        },
        OmniRegulae.EXIGIT_COMPOSITATEM to {
            exigitCompositatem()
        },
        OmniRegulae.EXIGIT_ISOLATIONEM to {
            exigitIsolationem()
        },
        OmniRegulae.EXIGIT_LATERALES to {
            exigitLaterales()
        },
        OmniRegulae.EXIGIT_BILATERALITATEM to {
            exigitBilateralitatem()
        },
        OmniRegulae.EXIGIT_UNILATERALITATEM to {
            exigitUnilateralitatem()
        },
        OmniRegulae.EXIGIT_MODUS_ONERIS to {
            exigitModusOneris()
        },
        OmniRegulae.EXIGIT_MODUM_CORPORIS to {
            exigitModumCorporis()
        },
        OmniRegulae.EXIGIT_MODUM_EXTERNUM to {
            exigitModumExternum()
        },
        OmniRegulae.EXIGIT_PREHENSIONES to {
            exigitPrehensiones()
        },
        OmniRegulae.EXIGIT_GENUS_PREHENSIONIS to {
            exigitGenusPrehensionis()
        },
        OmniRegulae.EXIGIT_ANGULUM_NON_NEGATIVUM to {
            exigitAngulumNonNegativum()
        },
        OmniRegulae.EXIGIT_ANGULOS_PERMISSOS to { archetypus ->
            exigitAngulos(
                *archetypus.angulusPermissae
                    .map { it.angulus.valor }
                    .toDoubleArray()
            )
        },
        OmniRegulae.EXIGIT_ANGULUM_MINIMUM to { archetypus ->
            exigitAngulumMinimum(archetypus.angulusMinimum)
        },
        OmniRegulae.VETAT_PREHENSIONES to {
            vetatPrehensiones()
        },
        OmniRegulae.VETAT_GENUS_PREHENSIONIS to {
            vetatGenusPrehenionis()
        },
        OmniRegulae.VETAT_ANGULUM to {
            vetatAngulum()
        }
    )
}
