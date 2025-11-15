package ars_disciplina.instrumentorum.entia

import ars_disciplina.instrumentorum.tabula.GenusInstrumenti
import ars_disciplina.instrumentorum.tabula.Instrumenta
import ars_disciplina.instrumentorum.valores.DescriptioInstrumenti

class EntiaInstrumenti(
    val instrumenta: Instrumenta,
    val descriptio: DescriptioInstrumenti,
    val genusInstrumenti: List<GenusInstrumenti>
)