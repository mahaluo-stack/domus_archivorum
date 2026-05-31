package org.example.disciplinarum.familia

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae
import org.example.commune.exemplaria.interfacia.FamiliaDisciplinae
import org.example.commune.registrum.RegistraDisciplinae
import org.example.disciplinarum.regulae.disciplinae.RegulaSquat
import org.example.disciplinarum.structor.StructorEntiaDisciplina

object SquatFamilia : FamiliaDisciplinae {

    override fun crea(): List<EntiaDisciplina> {

        return ConstantiaDisciplinae.SQUAT_FAMILY.map { nomenDisciplinae ->

            val disciplina = RegistraDisciplinae.invenirePerClavemNecesse(NomenDisciplinae(nomenDisciplinae))

            StructorEntiaDisciplina()
                .structDisciplinae(disciplina)
                .structVariationes(RegulaSquat.variationesPermissae)
                .structMotus(RegulaSquat.motusRequisitus)
                .struct()
        }
    }
}