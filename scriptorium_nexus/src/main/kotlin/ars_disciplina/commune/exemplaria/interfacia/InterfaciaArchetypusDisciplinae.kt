package org.example.commune.exemplaria.interfacia

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.disciplinarum.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.regularum.OmniRegulae

interface ArchetypusDisciplinae {
    val nomenArchetypi: String
    val disciplinae: Set<String>
    val regulae: Set<OmniRegulae>
    val variationesPermissae: Set<Variationes>
    val motusRequisitus: Motus
    val genusDisciplinaeRequisitus: GeneraDisciplinae
    val lateralisRequisitus: Set<Lateralis>
    val modusOnerisRequisitus: Set<ModusOneris>
    val prehensionesPermissae: Set<Prehensiones>
        get() = emptySet()
    val generaPrehensionisPermissae: Set<GeneraPrehensionis>
        get() = emptySet()
    val angulusPermissae: Set<Angulus>
        get() = emptySet()
    val angulusMinimum: Double
        get() = 0.0
    fun crea(): List<EntiaDisciplina>
}