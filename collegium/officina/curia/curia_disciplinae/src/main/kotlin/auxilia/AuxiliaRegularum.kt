package auxilia

import ars_disciplina.regularum.valores.RegulaeIdentitas
import io.ktor.server.application.*

fun ApplicationCall.regulaeIdentitas() = RegulaeIdentitas(identitas("identitas"))