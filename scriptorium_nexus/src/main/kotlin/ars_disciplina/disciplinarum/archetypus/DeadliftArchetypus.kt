package org.example.disciplinarum.familia

import ars_disciplina.classificationum.ConstantiaClassificationum.GENUS_COMPOUND
import ars_disciplina.classificationum.ConstantiaClassificationum.LATERALIS_BILATERAL
import ars_disciplina.classificationum.ConstantiaClassificationum.MODUS_ONERIS_EXTERNAL_LOAD
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.commune.registrum.*
import ars_disciplina.disciplinarum.EntiaDisciplina
import ars_disciplina.disciplinarum.constantia.ConstantiaDisciplinae
import ars_disciplina.disciplinarum.constantia.ConstantiaMotus.MOTUS_PULL
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.BANDED
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.DEFICIT
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.ECCENTRIC
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.ELEVATED
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.NEGATIVE
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.PAUSE
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.STANDING
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.TOUCH_AND_GO
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.NomenVariatones
import ars_disciplina.prehensionum.ConstantiaPrehensionum.GENUS_HOOK
import ars_disciplina.prehensionum.ConstantiaPrehensionum.GENUS_MIXED
import ars_disciplina.prehensionum.ConstantiaPrehensionum.GENUS_PRONATED
import ars_disciplina.prehensionum.ConstantiaPrehensionum.PREHENSIONES_NEUTRAL
import ars_disciplina.prehensionum.ConstantiaPrehensionum.PREHENSIONES_WIDE
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import ars_disciplina.regularum.constantia.OmniRegulae
import org.example.commune.exemplaria.interfacia.ArchetypusDisciplinae
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.commune.registrum.RegistraVariationes
import org.example.disciplinarum.structor.StructorEntiaDisciplina

object DeadliftArchetypus : ArchetypusDisciplinae {

    override val nomenArchetypi = "deadlift"
    override val disciplinae = ConstantiaDisciplinae.DEADLIFT_ARCHETYPUS
    override val regulae = setOf(
        OmniRegulae.EXIGIT_VARIATIONES,
        OmniRegulae.EXIGIT_TRACTIONEM,
        OmniRegulae.EXIGIT_GENUS_DISCIPLINAE,
        OmniRegulae.EXIGIT_BILATERALITATEM,
        OmniRegulae.EXIGIT_MODUM_EXTERNUM,
        OmniRegulae.EXIGIT_PREHENSIONES,
        OmniRegulae.EXIGIT_GENUS_PREHENSIONIS
    )
    override val variationesPermissae = setOf(
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(NEGATIVE)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(TOUCH_AND_GO)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(PAUSE)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(STANDING)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(ELEVATED)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(DEFICIT)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(ECCENTRIC)),
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(BANDED))
    )
    override val motusRequisitus = RegistraMotus.invenirePerClavemNecesse(
        NomenMotus(MOTUS_PULL)
    )
    override val genusDisciplinaeRequisitus = RegistraGeneraDisciplinae.invenirePerClavemNecesse(
        NomenGeneraDisciplinae(GENUS_COMPOUND)
    )
    override val lateralisRequisitus = setOf(
        RegistraLateralis.invenirePerClavemNecesse(NomenLateralis(LATERALIS_BILATERAL))
    )
    override val modusOnerisRequisitus = setOf(
        RegistraModusOneris.invenirePerClavemNecesse(NomenModusOneris(MODUS_ONERIS_EXTERNAL_LOAD))
    )
    override val prehensionesPermissae = setOf(
        RegistraPrehensiones.invenirePerClavemNecesse(NomenPrehensionis(PREHENSIONES_WIDE)),
        RegistraPrehensiones.invenirePerClavemNecesse(NomenPrehensionis(PREHENSIONES_NEUTRAL))
    )
    override val generaPrehensionisPermissae = setOf(
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_PRONATED)),
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_MIXED)),
        RegistraGeneraPrehensionis.invenirePerClavemNecesse(NomenGeneraPrehensionis(GENUS_HOOK))
    )

    override fun crea(): List<EntiaDisciplina> {

        return ConstantiaDisciplinae.DEADLIFT_ARCHETYPUS.map { nomenDisciplinae ->

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