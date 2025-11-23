package org.example.disciplinarum.regulae.disciplinae

import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.SQUAT_FAMILY
import org.example.commune.exemplaria.constantia.ConstantiaMotus.MOTUS_PUSH
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ASSISTED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.BANDED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ECCENTRIC
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ELEVATED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.NEGATIVE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.PAUSE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.PINNED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.STANDING
import org.example.disciplinarum.regulae.RegulaTribunal
import org.example.disciplinarum.regulae.regulaFamilia

object RegulaSquat {
    fun registra(tribunal: RegulaTribunal) {
        regulaFamilia(tribunal, SQUAT_FAMILY) {
            exigitDisciplinaVariationes(
                NEGATIVE,
                PAUSE,
                STANDING,
                ELEVATED,
                PINNED,
                ECCENTRIC,
                ASSISTED,
                BANDED
            )
            exigitMotum(MOTUS_PUSH)
            vetatAngulus()
            vetatPrehensiones()
            vetatGenusPrehenionis()
            exigitCompositatem()
            exigitBilateralitatem()
            exigitModosOneris()
        }
    }
}