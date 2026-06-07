package auxilia

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import io.ktor.server.application.*

fun ApplicationCall.musculiIdentitas() = MusculiIdentitas(identitas("identitas"))
fun ApplicationCall.musculiRegioIdentitas() = MusculiRegioIdentitas(identitas("identitas"))
fun ApplicationCall.musculiParsIdentitas() = MusculiParsIdentitas(identitas("identitas"))