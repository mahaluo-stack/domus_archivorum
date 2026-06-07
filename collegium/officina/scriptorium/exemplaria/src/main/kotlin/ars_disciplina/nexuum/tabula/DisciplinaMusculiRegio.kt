package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

data class DisciplinaMusculiRegio (
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val musculiRegioIdentitas: MusculiRegioIdentitas
)