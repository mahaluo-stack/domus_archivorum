package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas

data class DisciplinaMotus(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val motusIdentitas: MotusIdentitas
)