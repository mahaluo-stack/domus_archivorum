package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas

data class DisciplinaGeneraInstrumenti(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val genusInstrumentiIdentitas: GenusInstrumentiIdentitas
)