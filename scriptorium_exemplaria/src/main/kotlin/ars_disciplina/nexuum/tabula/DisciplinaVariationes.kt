package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas

data class DisciplinaVariationes(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val variationesIdentitas: VariationesIdentitas
)