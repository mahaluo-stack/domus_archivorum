package org.example.disciplinarum.regulae.disciplinae

import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.NomenVariatones
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import org.example.commune.exemplaria.constantia.ConstantiaClassificationum.GENUS_COMPOUND
import org.example.commune.exemplaria.constantia.ConstantiaClassificationum.LATERALIS_BILATERAL
import org.example.commune.exemplaria.constantia.ConstantiaClassificationum.MODUS_ONERIS_EXTERNAL_LOAD
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.DEADLIFT_FAMILY
import org.example.commune.exemplaria.constantia.ConstantiaMotus.MOTUS_PULL
import org.example.commune.exemplaria.constantia.ConstantiaPrehensionum.GENUS_HOOK
import org.example.commune.exemplaria.constantia.ConstantiaPrehensionum.GENUS_MIXED
import org.example.commune.exemplaria.constantia.ConstantiaPrehensionum.GENUS_PRONATED
import org.example.commune.exemplaria.constantia.ConstantiaPrehensionum.PREHENSIONES_NEUTRAL
import org.example.commune.exemplaria.constantia.ConstantiaPrehensionum.PREHENSIONES_WIDE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.BANDED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.DEFICIT
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ECCENTRIC
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ELEVATED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.NEGATIVE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.PAUSE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.STANDING
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.TOUCH_AND_GO
import org.example.commune.registrum.*
import org.example.commune.regulae.RegulaTribunal
import org.example.disciplinarum.regulae.regulaFamilia

object RegulaDeadlift {

    val variationesPermissae = setOf(
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(NEGATIVE)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(TOUCH_AND_GO)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(PAUSE)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(STANDING)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(ELEVATED)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(DEFICIT)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(ECCENTRIC)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(BANDED))
    )

    val motusRequisitus = RegistraMotus.invenirePerClavemNecesse(
        NomenMotus(MOTUS_PULL)
    )

    val genusDisciplinaeRequisitus = RegistraGeneraDisciplinae.invenirePerClavemNecesse(
        NomenGeneraDisciplinae(GENUS_COMPOUND)
    )

    val lateralisRequisitus = RegistraLateralis.invenirePerClavemNecesse(
        NomenLateralis(LATERALIS_BILATERAL)
    )

    val modusOnerisRequisitus = RegistraModusOneris.invenirePerClavemNecesse(
        NomenModusOneris(MODUS_ONERIS_EXTERNAL_LOAD)
    )

    val prehensionesPermissae = setOf(
        RegistraPrehensiones.invenirePerClavemNecesse(NomenPrehensionis(PREHENSIONES_WIDE)),
        RegistraPrehensiones.invenirePerClavemNecesse(NomenPrehensionis(PREHENSIONES_NEUTRAL))
    )

    val generaPrehensionisPermissae = setOf(
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_PRONATED)),
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_MIXED)),
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_HOOK))
    )

    fun registra(tribunal: RegulaTribunal) {

        val nomenDisciplinaVariatones = variationesPermissae.map { it.nomen.valor }
        val nomenPrehensionis = prehensionesPermissae.map { it.nomen.valor }
        val generaPrehensionisPermissae = generaPrehensionisPermissae.map { it.nomen.valor }

        regulaFamilia(tribunal, DEADLIFT_FAMILY) {
            exigitDisciplinaVariationes(*nomenDisciplinaVariatones.toTypedArray())
            exigitMotum(motusRequisitus.nomen.valor)
            vetatAngulus()
            exigitPrehensiones(*nomenPrehensionis.toTypedArray())
            exigitGenusPrehensionis(*generaPrehensionisPermissae.toTypedArray())
            exigitCompositatem()
            exigitBilateralitatem()
            exigitModumExternum()
        }
    }
}