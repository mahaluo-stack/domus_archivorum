package ars_disciplina.nexuum.tabula

import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas

data class DisciplinaLateralitates(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val lateralisIdentitas: LateralisIdentitas
)