package org.example.disciplinarum.regulae.disciplinae

import ars_disciplina.disciplinarum.valores.NomenDisciplinaVariatones
import ars_disciplina.disciplinarum.valores.NomenMotus
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.SQUAT_FAMILY
import org.example.commune.exemplaria.constantia.ConstantiaMotus.MOTUS_PUSH
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.BANDED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ECCENTRIC
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ELEVATED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.NEGATIVE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.PAUSE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.PINNED
import org.example.commune.registrum.RegistraVariationes
import org.example.commune.registrum.RegistraMotus
import org.example.commune.regulae.RegulaTribunal
import org.example.disciplinarum.regulae.regulaFamilia

object RegulaSquat {

    val variationesPermissae = setOf(
        RegistraVariationes.invenirePerClavemNecesse(NomenDisciplinaVariatones(NEGATIVE)),
        RegistraVariationes.invenirePerClavemNecesse(NomenDisciplinaVariatones(PAUSE)),
        RegistraVariationes.invenirePerClavemNecesse(NomenDisciplinaVariatones(ELEVATED)),
        RegistraVariationes.invenirePerClavemNecesse(NomenDisciplinaVariatones(PINNED)),
        RegistraVariationes.invenirePerClavemNecesse(NomenDisciplinaVariatones(ECCENTRIC)),
        RegistraVariationes.invenirePerClavemNecesse(NomenDisciplinaVariatones(BANDED))
    )

    val motusRequisitus = RegistraMotus.invenirePerClavemNecesse(
        NomenMotus(MOTUS_PUSH))

    fun registra(tribunal: RegulaTribunal) {

        val nomenDisciplinaVariatones = RegulaDeadlift.variationesPermissae.map { it.nomen.valor }

        regulaFamilia(tribunal, SQUAT_FAMILY) {
            exigitDisciplinaVariationes(*nomenDisciplinaVariatones.toTypedArray())
            exigitMotum(motusRequisitus.nomen.valor)
            vetatAngulus()
            vetatPrehensiones()
            vetatGenusPrehenionis()
            exigitCompositatem()
            exigitBilateralitatem()
            exigitModosOneris()
        }
    }
}