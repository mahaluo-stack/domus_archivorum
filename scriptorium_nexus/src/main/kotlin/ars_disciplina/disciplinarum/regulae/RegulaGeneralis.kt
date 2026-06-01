package ars_disciplina.disciplinarum.regulae

import ars_disciplina.disciplinarum.constantia.ConstantiaDisciplinae
import ars_disciplina.disciplinarum.constantia.ConstantiaMotus
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum
import ars_disciplina.prehensionum.ConstantiaPrehensionum
import org.example.commune.regulae.RegulaTribunal
import org.example.disciplinarum.regulae.regulaExercitatio

object RegulaGeneralis {
    fun registra(tribunal: RegulaTribunal) {
        regulaExercitatio(tribunal, ConstantiaDisciplinae.BENCH_PRESS) {
            exigitDisciplinaVariationes(
                ConstantiaVariationum.NEGATIVE,
                ConstantiaVariationum.PAUSE,
                ConstantiaVariationum.ECCENTRIC,
                ConstantiaVariationum.INCLINE,
                ConstantiaVariationum.DECLINE,
                ConstantiaVariationum.BANDED
            )
            exigitMotum(ConstantiaMotus.MOTUS_PUSH)
            exigitAngulum()
            exigitPrehensiones()
            vetatGenusPrehenionis()
            exigitCompositatem()
            exigitBilateralitatem()
            exigitModumExternum()
        }
        regulaExercitatio(tribunal, ConstantiaDisciplinae.DIP) {
            exigitDisciplinaVariationes(
                ConstantiaVariationum.NEGATIVE,
                ConstantiaVariationum.PAUSE,
                ConstantiaVariationum.ECCENTRIC,
                ConstantiaVariationum.ASSISTED,
                ConstantiaVariationum.WEIGHTED
            )
            exigitMotum(ConstantiaMotus.MOTUS_PUSH)
            vetatAngulum()
            vetatPrehensiones()
            vetatGenusPrehenionis()
            exigitCompositatem()
            exigitBilateralitatem()
            exigitModosOneris()
        }
        regulaExercitatio(tribunal, ConstantiaDisciplinae.FLYE) {
            exigitDisciplinaVariationes(
                ConstantiaVariationum.NEGATIVE,
                ConstantiaVariationum.PAUSE,
                ConstantiaVariationum.SEATED,
                ConstantiaVariationum.STANDING,
                ConstantiaVariationum.ECCENTRIC,
                ConstantiaVariationum.INCLINE,
                ConstantiaVariationum.FLAT
            )
            exigitMotum(ConstantiaMotus.MOTUS_FLYE)
            exigitAngulumNonNegativum()
            vetatPrehensiones()
            exigitGenusPrehensionis(
                ConstantiaPrehensionum.GENUS_NEUTRAL,
                ConstantiaPrehensionum.GENUS_PRONATED,
                ConstantiaPrehensionum.GENUS_SUPINATED
            )
            exigitIsolationem()
            exigitLaterales()
            exigitModumExternum()
        }
        regulaExercitatio(tribunal, ConstantiaDisciplinae.FRONT_DELT_RAISE) {
            exigitDisciplinaVariationes(
                ConstantiaVariationum.PAUSE,
                ConstantiaVariationum.SEATED,
                ConstantiaVariationum.STANDING,
                ConstantiaVariationum.ECCENTRIC,
                ConstantiaVariationum.INCLINE
            )
            exigitMotum(ConstantiaMotus.MOTUS_PUSH)
            exigitAngulumNonNegativum()
            exigitGenusPrehensionis(
                ConstantiaPrehensionum.GENUS_NEUTRAL,
                ConstantiaPrehensionum.GENUS_PRONATED,
                ConstantiaPrehensionum.GENUS_SUPINATED
            )
            exigitIsolationem()
            exigitLaterales()
            exigitModumExternum()
        }
        regulaExercitatio(tribunal, ConstantiaDisciplinae.REAR_DELT_RAISE) {
            exigitDisciplinaVariationes(
                ConstantiaVariationum.PAUSE,
                ConstantiaVariationum.SEATED,
                ConstantiaVariationum.STANDING,
                ConstantiaVariationum.ECCENTRIC,
                ConstantiaVariationum.INCLINE
            )
            exigitMotum(ConstantiaMotus.MOTUS_PULL)
            exigitAngulumNonNegativum()
            exigitGenusPrehensionis(
                ConstantiaPrehensionum.GENUS_NEUTRAL,
                ConstantiaPrehensionum.GENUS_PRONATED
            )
            exigitIsolationem()
            exigitLaterales()
            exigitModumExternum()
        }
        regulaExercitatio(tribunal, ConstantiaDisciplinae.LATERAL_DELT_RAISE) {
            exigitDisciplinaVariationes(
                ConstantiaVariationum.PAUSE,
                ConstantiaVariationum.SEATED,
                ConstantiaVariationum.STANDING,
                ConstantiaVariationum.ECCENTRIC
            )
            exigitMotum(ConstantiaMotus.MOTUS_PULL)
            exigitAngulumNonNegativum()
            exigitGenusPrehensionis(
                ConstantiaPrehensionum.GENUS_NEUTRAL,
                ConstantiaPrehensionum.GENUS_PRONATED
            )
            exigitIsolationem()
            exigitLaterales()
            exigitModumExternum()
        }
        regulaExercitatio(tribunal, ConstantiaDisciplinae.TRICEP_EXTENSION) {
            exigitDisciplinaVariationes(
                ConstantiaVariationum.NEGATIVE,
                ConstantiaVariationum.PAUSE,
                ConstantiaVariationum.SEATED,
                ConstantiaVariationum.STANDING,
                ConstantiaVariationum.ECCENTRIC,
                ConstantiaVariationum.INCLINE
            )
            exigitMotum(ConstantiaMotus.MOTUS_PUSH)
            exigitAngulumNonNegativum()
            exigitGenusPrehensionis(
                ConstantiaPrehensionum.GENUS_NEUTRAL,
                ConstantiaPrehensionum.GENUS_PRONATED,
                ConstantiaPrehensionum.GENUS_SUPINATED
            )
            exigitIsolationem()
            exigitLaterales()
            exigitModumExternum()
        }
    }
}