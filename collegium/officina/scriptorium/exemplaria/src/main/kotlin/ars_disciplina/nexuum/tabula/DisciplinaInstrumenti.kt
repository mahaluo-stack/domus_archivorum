package ars_disciplina.nexuum.tabula

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas

data class DisciplinaInstrumenti (
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val instrumentaIdentitas: InstrumentaIdentitas
)