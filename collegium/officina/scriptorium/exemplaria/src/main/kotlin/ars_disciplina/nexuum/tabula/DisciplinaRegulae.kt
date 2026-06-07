package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.regularum.valores.RegulaeIdentitas

data class DisciplinaRegulae(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val regulaeIdentitas: RegulaeIdentitas
)