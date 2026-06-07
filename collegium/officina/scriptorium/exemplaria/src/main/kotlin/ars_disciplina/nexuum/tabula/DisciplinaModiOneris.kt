package ars_disciplina.nexuum.tabula

import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas

data class DisciplinaModiOneris(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val modusOnerisIdentitas: ModusOnerisIdentitas
)