package org.example.disciplinarum.regulae.disciplinae

import ars_disciplina.disciplinarum.valores.NomenMotus
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.LUNGE_FAMILY
import org.example.commune.exemplaria.constantia.ConstantiaMotus.MOTUS_PUSH
import org.example.commune.registrum.RegistraMotus
import org.example.commune.regulae.RegulaTribunal
import org.example.disciplinarum.regulae.regulaFamilia

object RegulaLunge {

    val motusRequisitus = RegistraMotus.invenirePerClavemNecesse(
        NomenMotus(MOTUS_PUSH))

    fun registra(tribunal: RegulaTribunal) {
        regulaFamilia(tribunal, LUNGE_FAMILY) {
            exigitMotum(motusRequisitus.nomen.valor)
            vetatAngulus()
            vetatPrehensiones()
            vetatGenusPrehenionis()
            exigitCompositatem()
            exigitUnilateralitatem()
            exigitModosOneris()
        }
    }
}