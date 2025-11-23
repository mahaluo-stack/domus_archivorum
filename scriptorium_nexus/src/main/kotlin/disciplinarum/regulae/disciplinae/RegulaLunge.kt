package org.example.disciplinarum.regulae.disciplinae

import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.LUNGE_FAMILY
import org.example.commune.exemplaria.constantia.ConstantiaMotus.MOTUS_PUSH
import org.example.disciplinarum.regulae.RegulaTribunal
import org.example.disciplinarum.regulae.regulaFamilia

object RegulaLunge {
    fun registra(tribunal: RegulaTribunal) {
        regulaFamilia(tribunal, LUNGE_FAMILY) {
            exigitMotum(MOTUS_PUSH)
            vetatAngulus()
            vetatPrehensiones()
            vetatGenusPrehenionis()
            exigitCompositatem()
            exigitUnilateralitatem()
            exigitModosOneris()
        }
    }
}