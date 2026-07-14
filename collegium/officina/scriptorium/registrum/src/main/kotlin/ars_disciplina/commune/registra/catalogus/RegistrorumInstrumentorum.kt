package ars_disciplina.commune.registra.catalogus

import ars_disciplina.instrumentorum.tabula.GenusInstrumenti
import ars_disciplina.instrumentorum.tabula.Instrumenta
import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import org.example.commune.registrum.Registra


object RegistraInstrumenti : Registra<InstrumentaIdentitas, Instrumenta>({ it.instrumentaIdentitas })
object RegistraGeneraInstrumenti : Registra<GenusInstrumentiIdentitas, GenusInstrumenti>({ it.genusInstrumentIdentitas })