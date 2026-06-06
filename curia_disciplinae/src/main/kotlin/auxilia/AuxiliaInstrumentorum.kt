package auxilia

import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import io.ktor.server.application.*

fun ApplicationCall.instrumentaIdentitas() = InstrumentaIdentitas(identitas("identitas"))
fun ApplicationCall.genusInstrumenti() = GenusInstrumentiIdentitas(identitas("identitas"))