package ars_disciplina.instrumentorum.tabula

import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas
import ars_disciplina.instrumentorum.valores.NomenInstrumenti

data class GenusInstrumenti(
    val genusInstrumentIdentitas: GenusInstrumentiIdentitas,
    val nomen: NomenInstrumenti
)