package ars_disciplina.nexuum.tabula

import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas

data class DisciplinaGeneraDisciplinae(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val generaDisciplinaeIdentitas: GeneraDisciplinaeIdentitas
)