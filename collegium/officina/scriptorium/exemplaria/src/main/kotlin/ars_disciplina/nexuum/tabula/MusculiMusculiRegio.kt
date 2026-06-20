package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

data class MusculiMusculiRegio(
    val musculiIdentitas: MusculiIdentitas,
    val musculiRegioIdentitas: MusculiRegioIdentitas
)