package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas

data class DisciplinaAnguli(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val angulusIdentitas: AngulusIdentitas
)