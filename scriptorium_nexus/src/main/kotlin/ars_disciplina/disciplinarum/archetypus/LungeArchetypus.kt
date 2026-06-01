package org.example.disciplinarum.familia

import ars_disciplina.classificationum.ConstantiaClassificationum.GENUS_COMPOUND
import ars_disciplina.classificationum.ConstantiaClassificationum.LATERALIS_UNILATERAL
import ars_disciplina.classificationum.ConstantiaClassificationum.MODUS_ONERIS_BODYWEIGHT
import ars_disciplina.classificationum.ConstantiaClassificationum.MODUS_ONERIS_EXTERNAL_LOAD
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.commune.registrum.RegistraGeneraDisciplinae
import ars_disciplina.commune.registrum.RegistraLateralis
import ars_disciplina.commune.registrum.RegistraModusOneris
import ars_disciplina.disciplinarum.EntiaDisciplina
import ars_disciplina.disciplinarum.constantia.ConstantiaDisciplinae
import ars_disciplina.disciplinarum.constantia.ConstantiaMotus.MOTUS_PUSH
import ars_disciplina.disciplinarum.constantia.ConstantiaVariationum.PAUSE
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.NomenVariatones
import ars_disciplina.regularum.constantia.OmniRegulae
import org.example.commune.exemplaria.interfacia.ArchetypusDisciplinae
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.commune.registrum.RegistraVariationes
import org.example.disciplinarum.structor.StructorEntiaDisciplina

object LungeArchetypus : ArchetypusDisciplinae {

    override val nomenArchetypi = "lunge"
    override val disciplinae = ConstantiaDisciplinae.LUNGE_ARCHETYPUS

    override val regulae = setOf(
        OmniRegulae.EXIGIT_PROPULSIONEM,
        OmniRegulae.VETAT_ANGULUM,
        OmniRegulae.VETAT_PREHENSIONES,
        OmniRegulae.VETAT_GENUS_PREHENSIONIS,
        OmniRegulae.EXIGIT_COMPOSITATEM,
        OmniRegulae.EXIGIT_UNILATERALITATEM,
        OmniRegulae.EXIGIT_MODUS_ONERIS
    )
    override val variationesPermissae = setOf(
        RegistraVariationes.invenirePerClavemNecesse(NomenVariatones(PAUSE))
    )
    override val motusRequisitus = RegistraMotus.invenirePerClavemNecesse(
        NomenMotus(MOTUS_PUSH))
    override val genusDisciplinaeRequisitus = RegistraGeneraDisciplinae.invenirePerClavemNecesse(
        NomenGeneraDisciplinae(GENUS_COMPOUND)
    )
    override val lateralisRequisitus = setOf(
        RegistraLateralis.invenirePerClavemNecesse(NomenLateralis(LATERALIS_UNILATERAL))
    )
    override val modusOnerisRequisitus = setOf(
        RegistraModusOneris.invenirePerClavemNecesse(NomenModusOneris(MODUS_ONERIS_EXTERNAL_LOAD)),
        RegistraModusOneris.invenirePerClavemNecesse(NomenModusOneris(MODUS_ONERIS_BODYWEIGHT))
    )

    override fun crea(): List<EntiaDisciplina> {

        return ConstantiaDisciplinae.LUNGE_ARCHETYPUS.map { nomenDisciplinae ->

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