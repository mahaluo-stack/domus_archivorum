package ars_disciplina.disciplinarum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaVariationesIdentitas
import ars_disciplina.disciplinarum.valores.NomenDisciplinaVariatones

data class DisciplinaVariationes(
    val disciplinaVariationesIdentitas: DisciplinaVariationesIdentitas,
    val nomen: NomenDisciplinaVariatones
)