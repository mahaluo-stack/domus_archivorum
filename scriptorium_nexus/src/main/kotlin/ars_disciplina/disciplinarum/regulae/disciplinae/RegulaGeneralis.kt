package org.example.disciplinarum.regulae.disciplinae

import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.BENCH_PRESS
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.DIP
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.FLYE
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.FRONT_DELT_RAISE
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.LATERAL_DELT_RAISE
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.REAR_DELT_RAISE
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.TRICEP_EXTENSION
import org.example.commune.exemplaria.constantia.ConstantiaMotus.MOTUS_FLYE
import org.example.commune.exemplaria.constantia.ConstantiaMotus.MOTUS_PULL
import org.example.commune.exemplaria.constantia.ConstantiaMotus.MOTUS_PUSH
import org.example.commune.exemplaria.constantia.ConstantiaPrehensionum.GENUS_NEUTRAL
import org.example.commune.exemplaria.constantia.ConstantiaPrehensionum.GENUS_PRONATED
import org.example.commune.exemplaria.constantia.ConstantiaPrehensionum.GENUS_SUPINATED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ASSISTED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.BANDED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.DECLINE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ECCENTRIC
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.FLAT
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.INCLINE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.NEGATIVE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.PAUSE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.SEATED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.STANDING
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.WEIGHTED
import org.example.commune.regulae.RegulaTribunal
import org.example.disciplinarum.regulae.regulaExercitatio


object RegulaGeneralis {
    fun registra(tribunal: RegulaTribunal) {
        regulaExercitatio(tribunal, BENCH_PRESS) {
            exigitDisciplinaVariationes(
                NEGATIVE,
                PAUSE,
                ECCENTRIC,
                INCLINE,
                DECLINE,
                BANDED
            )
            exigitMotum(MOTUS_PUSH)
            exigitAngulum()
            exigitPrehensiones()
            vetatGenusPrehenionis()
            exigitCompositatem()
            exigitBilateralitatem()
            exigitModumExternum()
        }
        regulaExercitatio(tribunal, DIP) {
            exigitDisciplinaVariationes(
                NEGATIVE,
                PAUSE,
                ECCENTRIC,
                ASSISTED,
                WEIGHTED
            )
            exigitMotum(MOTUS_PUSH)
            vetatAngulum()
            vetatPrehensiones()
            vetatGenusPrehenionis()
            exigitCompositatem()
            exigitBilateralitatem()
            exigitModosOneris()
        }
        regulaExercitatio(tribunal, FLYE) {
            exigitDisciplinaVariationes(
                NEGATIVE,
                PAUSE,
                SEATED,
                STANDING,
                ECCENTRIC,
                INCLINE,
                FLAT
            )
            exigitMotum(MOTUS_FLYE)
            exigitAngulumNonNegativum()
            vetatPrehensiones()
            exigitGenusPrehensionis(
                GENUS_NEUTRAL,
                GENUS_PRONATED,
                GENUS_SUPINATED
            )
            exigitIsolationem()
            exigitLaterales()
            exigitModumExternum()
        }
        regulaExercitatio(tribunal, FRONT_DELT_RAISE) {
            exigitDisciplinaVariationes(
                PAUSE,
                SEATED,
                STANDING,
                ECCENTRIC,
                INCLINE
            )
            exigitMotum(MOTUS_PUSH)
            exigitAngulumNonNegativum()
            exigitGenusPrehensionis(
                GENUS_NEUTRAL,
                GENUS_PRONATED,
                GENUS_SUPINATED
            )
            exigitIsolationem()
            exigitLaterales()
            exigitModumExternum()
        }
        regulaExercitatio(tribunal, REAR_DELT_RAISE) {
            exigitDisciplinaVariationes(
                PAUSE,
                SEATED,
                STANDING,
                ECCENTRIC,
                INCLINE
            )
            exigitMotum(MOTUS_PULL)
            exigitAngulumNonNegativum()
            exigitGenusPrehensionis(
                GENUS_NEUTRAL,
                GENUS_PRONATED
            )
            exigitIsolationem()
            exigitLaterales()
            exigitModumExternum()
        }
        regulaExercitatio(tribunal, LATERAL_DELT_RAISE) {
            exigitDisciplinaVariationes(
                PAUSE,
                SEATED,
                STANDING,
                ECCENTRIC
            )
            exigitMotum(MOTUS_PULL)
            exigitAngulumNonNegativum()
            exigitGenusPrehensionis(
                GENUS_NEUTRAL,
                GENUS_PRONATED
            )
            exigitIsolationem()
            exigitLaterales()
            exigitModumExternum()
        }
        regulaExercitatio(tribunal, TRICEP_EXTENSION) {
            exigitDisciplinaVariationes(
                NEGATIVE,
                PAUSE,
                SEATED,
                STANDING,
                ECCENTRIC,
                INCLINE
            )
            exigitMotum(MOTUS_PUSH)
            exigitAngulumNonNegativum()
            exigitGenusPrehensionis(
                GENUS_NEUTRAL,
                GENUS_PRONATED,
                GENUS_SUPINATED
            )
            exigitIsolationem()
            exigitLaterales()
            exigitModumExternum()
        }
    }
}