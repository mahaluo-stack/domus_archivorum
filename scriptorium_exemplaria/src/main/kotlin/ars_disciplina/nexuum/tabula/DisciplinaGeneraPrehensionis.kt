package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas

data class DisciplinaGeneraPrehensionis(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val generaPrehensionisIdentitas: GeneraPrehensionisIdentitas
)