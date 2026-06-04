package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas

data class DisciplinaPrehensiones(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val prehensionesIdentitas: PrehensionesIdentitas
)