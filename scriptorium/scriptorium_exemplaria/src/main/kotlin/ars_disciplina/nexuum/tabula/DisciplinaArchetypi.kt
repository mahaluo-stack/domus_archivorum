package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.ArchetypusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas

data class DisciplinaArchetypi(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val archetypusIdentitas: ArchetypusIdentitas
)