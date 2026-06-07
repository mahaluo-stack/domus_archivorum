package ars_disciplina.instrumentorum.tabula

import ars_disciplina.instrumentorum.valores.DescriptioInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import ars_disciplina.instrumentorum.valores.NomenInstrumenti

data class Instrumenta(
    val instrumentaIdentitas: InstrumentaIdentitas,
    val nomen: NomenInstrumenti,
    val descriptio: DescriptioInstrumenti
)
