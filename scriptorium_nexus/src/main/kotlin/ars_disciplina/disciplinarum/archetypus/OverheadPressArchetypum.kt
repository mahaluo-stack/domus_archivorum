package ars_disciplina.disciplinarum.archetypus

import ars_disciplina.classificationum.ConstantiaClassificationum.GENUS_COMPOUND
import ars_disciplina.classificationum.ConstantiaClassificationum.LATERALIS_BILATERAL
import ars_disciplina.classificationum.ConstantiaClassificationum.LATERALIS_UNILATERAL
import ars_disciplina.classificationum.ConstantiaClassificationum.MODUS_ONERIS_EXTERNAL_LOAD
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.commune.registrum.*
import ars_disciplina.disciplinarum.EntiaDisciplina
import ars_disciplina.disciplinarum.constantia.ConstantiaDisciplinae
import ars_disciplina.disciplinarum.constantia.ConstantiaMotus.MOTUS_PUSH
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.ASSISTED
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.BANDED
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.ECCENTRIC
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.NEGATIVE
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.PAUSE
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.PINNED
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.SEATED
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.STANDING
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.NomenVariatones
import ars_disciplina.prehensionum.ConstantiaPrehensionum.GENUS_NEUTRAL
import ars_disciplina.prehensionum.ConstantiaPrehensionum.GENUS_PRONATED
import ars_disciplina.prehensionum.ConstantiaPrehensionum.PREHENSIONES_CLOSE
import ars_disciplina.prehensionum.ConstantiaPrehensionum.PREHENSIONES_NEUTRAL
import ars_disciplina.prehensionum.ConstantiaPrehensionum.PREHENSIONES_WIDE
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import ars_disciplina.regularum.OmniRegulae
import org.example.commune.exemplaria.interfacia.ArchetypusDisciplinae
import org.example.commune.registrum.RegistraAngulus
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.commune.registrum.RegistraVariationes
import org.example.disciplinarum.structor.StructorEntiaDisciplina

object OverheadPressArchetypum : ArchetypusDisciplinae {
    override val nomenArchetypi = "overhead press"
    override val disciplinae = ConstantiaDisciplinae.OVERHEAD_PRESS_ARCHETYPUS

    override val regulae = setOf(
        OmniRegulae.EXIGIT_PROPULSIONEM,
        OmniRegulae.EXIGIT_COMPOSITATEM,
        OmniRegulae.EXIGIT_VARIATIONES,
        OmniRegulae.EXIGIT_BILATERALITATEM,
        OmniRegulae.EXIGIT_UNILATERALITATEM,
        OmniRegulae.EXIGIT_MODUM_EXTERNUM,
        OmniRegulae.EXIGIT_ANGULOS_PERMISSOS
    )
    override val variationesPermissae = setOf(
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(NEGATIVE)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(PAUSE)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(SEATED)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(STANDING)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(PINNED)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(ECCENTRIC)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(ASSISTED)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(BANDED)),
    )

    override val motusRequisitus = RegistraMotus.invenirePerClavemNecesse(
        NomenMotus(MOTUS_PUSH))

    override val genusDisciplinaeRequisitus = RegistraGeneraDisciplinae.invenirePerClavemNecesse(
        NomenGeneraDisciplinae(GENUS_COMPOUND)
    )
    override val lateralisRequisitus = setOf(
        RegistraLateralis.invenirePerClavemNecesse(NomenLateralis(LATERALIS_UNILATERAL)),
        RegistraLateralis.invenirePerClavemNecesse(NomenLateralis(LATERALIS_BILATERAL))
    )
    override val modusOnerisRequisitus = setOf(
        RegistraModusOneris.invenirePerClavemNecesse(NomenModusOneris(MODUS_ONERIS_EXTERNAL_LOAD))
    )
    override val prehensionesPermissae = setOf(
        RegistraPrehensiones.invenirePerClavemNecesse(NomenPrehensionis(PREHENSIONES_NEUTRAL)),
        RegistraPrehensiones.invenirePerClavemNecesse(NomenPrehensionis(PREHENSIONES_WIDE)),
        RegistraPrehensiones.invenirePerClavemNecesse(NomenPrehensionis(PREHENSIONES_CLOSE))
    )
    override val generaPrehensionisPermissae = setOf(
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_PRONATED)),
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_NEUTRAL))
    )
    override val angulusMinimum = 60.0

    override fun crea(): List<EntiaDisciplina> {
        return ConstantiaDisciplinae.OVERHEAD_PRESS_ARCHETYPUS.map { nomenDisciplinae ->

            val disciplina = RegistraDisciplinae.invenirePerClavemNecesse(NomenDisciplinae(nomenDisciplinae))

            StructorEntiaDisciplina()
                .structDisciplinae(disciplina)
                .structGeneraDisciplinae(genusDisciplinaeRequisitus)
                .structMotus(motusRequisitus)
                .structModusOneris(modusOnerisRequisitus)
                .structLateralis(lateralisRequisitus)
                .structVariationes(variationesPermissae)
                .structPrehensiones(prehensionesPermissae)
                .structGeneraPrehensiones(generaPrehensionisPermissae)
                .structAngulus(RegistraAngulus.omnia()
                    .filter { it.angulus.valor > angulusMinimum }
                    .toSet())
                .struct()
        }
    }
}