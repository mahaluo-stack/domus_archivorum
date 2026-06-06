package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas

data class DisciplinaMusculi (
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val musculiIdentitas: MusculiIdentitas
)