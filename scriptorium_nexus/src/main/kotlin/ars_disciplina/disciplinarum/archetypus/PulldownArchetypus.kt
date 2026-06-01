package ars_disciplina.disciplinarum.archetypus

import ars_disciplina.classificationum.ConstantiaClassificationum.GENUS_COMPOUND
import ars_disciplina.classificationum.ConstantiaClassificationum.LATERALIS_BILATERAL
import ars_disciplina.classificationum.ConstantiaClassificationum.LATERALIS_UNILATERAL
import ars_disciplina.classificationum.ConstantiaClassificationum.MODUS_ONERIS_BODYWEIGHT
import ars_disciplina.classificationum.ConstantiaClassificationum.MODUS_ONERIS_EXTERNAL_LOAD
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.commune.registrum.*
import ars_disciplina.disciplinarum.EntiaDisciplina
import ars_disciplina.disciplinarum.constantia.ConstantiaDisciplinae
import ars_disciplina.disciplinarum.constantia.ConstantiaMotus.MOTUS_PULL
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.ASSISTED
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.BANDED
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.ECCENTRIC
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.NEGATIVE
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.PAUSE
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.SEATED
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.WEIGHTED
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.NomenVariatones
import ars_disciplina.prehensionum.ConstantiaPrehensionum.GENUS_NEUTRAL
import ars_disciplina.prehensionum.ConstantiaPrehensionum.GENUS_PRONATED
import ars_disciplina.prehensionum.ConstantiaPrehensionum.GENUS_SUPINATED
import ars_disciplina.prehensionum.ConstantiaPrehensionum.PREHENSIONES_CLOSE
import ars_disciplina.prehensionum.ConstantiaPrehensionum.PREHENSIONES_NEUTRAL
import ars_disciplina.prehensionum.ConstantiaPrehensionum.PREHENSIONES_WIDE
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import ars_disciplina.regularum.OmniRegulae
import org.example.commune.exemplaria.interfacia.ArchetypusDisciplinae
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.commune.registrum.RegistraVariationes
import org.example.disciplinarum.structor.StructorEntiaDisciplina

object PulldownArchetypus : ArchetypusDisciplinae {

    override val nomenArchetypi = "pulldown"
    override val disciplinae = ConstantiaDisciplinae.PULLDOWN_ARCHETYPUS
    override val regulae = setOf(
        OmniRegulae.EXIGIT_VARIATIONES,
        OmniRegulae.EXIGIT_TRACTIONEM,
        OmniRegulae.VETAT_ANGULUM,
        OmniRegulae.EXIGIT_PREHENSIONES,
        OmniRegulae.EXIGIT_GENUS_PREHENSIONIS,
        OmniRegulae.EXIGIT_BILATERALITATEM,
        OmniRegulae.EXIGIT_UNILATERALITATEM,
        OmniRegulae.EXIGIT_COMPOSITATEM
    )
    override val variationesPermissae = setOf(
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(NEGATIVE)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(PAUSE)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(SEATED)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(ECCENTRIC)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(ASSISTED)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(BANDED)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(WEIGHTED))
    )
    override val motusRequisitus = RegistraMotus.invenirePerClavemNecesse(
        NomenMotus(MOTUS_PULL))
    override val genusDisciplinaeRequisitus = RegistraGeneraDisciplinae.invenirePerClavemNecesse(
        NomenGeneraDisciplinae(GENUS_COMPOUND)
    )
    override val lateralisRequisitus = setOf(
        RegistraLateralis.invenirePerClavemNecesse(NomenLateralis(LATERALIS_UNILATERAL)),
        RegistraLateralis.invenirePerClavemNecesse(NomenLateralis(LATERALIS_BILATERAL))
    )
    override val modusOnerisRequisitus = setOf(
        RegistraModusOneris.invenirePerClavemNecesse(NomenModusOneris(MODUS_ONERIS_EXTERNAL_LOAD)),
        RegistraModusOneris.invenirePerClavemNecesse(NomenModusOneris(MODUS_ONERIS_BODYWEIGHT))
    )
    override val prehensionesPermissae = setOf(
        RegistraPrehensiones.invenirePerClavemNecesse(NomenPrehensionis(PREHENSIONES_NEUTRAL)),
        RegistraPrehensiones.invenirePerClavemNecesse(NomenPrehensionis(PREHENSIONES_WIDE)),
        RegistraPrehensiones.invenirePerClavemNecesse(NomenPrehensionis(PREHENSIONES_CLOSE))
    )
    override val generaPrehensionisPermissae = setOf(
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_SUPINATED)),
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_PRONATED)),
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_NEUTRAL))
    )

    override fun crea(): List<EntiaDisciplina> {

        return ConstantiaDisciplinae.PULLDOWN_ARCHETYPUS.map { nomenDisciplinae ->

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
                .struct()
        }
    }
}