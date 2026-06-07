package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas

data class DisciplinaMusculiPars (
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val musculiParsIdentitas: MusculiParsIdentitas
)