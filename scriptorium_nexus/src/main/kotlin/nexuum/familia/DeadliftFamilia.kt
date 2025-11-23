package org.example.nexuum.familia

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae
import org.example.commune.exemplaria.interfacia.FamiliaDisciplinae
import org.example.commune.registrum.RegistraDisciplinae
import org.example.disciplinarum.regulae.disciplinae.RegulaDeadlift
import org.example.disciplinarum.structor.StructorDisciplinae

object DeadliftFamilia : FamiliaDisciplinae {

    override fun crea(): List<EntiaDisciplina> {

        return ConstantiaDisciplinae.DEADLIFT_FAMILY.map { nomenDisciplinae ->

            val disciplina = RegistraDisciplinae.invenirePerClavemNecesse(NomenDisciplinae(nomenDisciplinae))

            StructorDisciplinae()
                .structDisciplinae(disciplina)
                .structGeneraDisciplinae(RegulaDeadlift.genusDisciplinaeRequisitus)
                .structMotus(RegulaDeadlift.motusRequisitus)
                .structModusOneris(setOf(RegulaDeadlift.modusOnerisRequisitus))
                .structLateralisDisciplinae(setOf(RegulaDeadlift.lateralisRequisitus))
                .structVariationes(RegulaDeadlift.variationesPermissae)
                .structAngulus(emptySet())
                .structPrehensiones(RegulaDeadlift.prehensionesPermissae)
                .structGeneraPrehensiones(RegulaDeadlift.generaPrehensionisPermissae)
                .struct()
        }
    }
}