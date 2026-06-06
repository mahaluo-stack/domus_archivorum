package auxilia

import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import io.ktor.server.application.*

fun ApplicationCall.generaDisciplinaeIdentitas() = GeneraDisciplinaeIdentitas(identitas("identitas"))
fun ApplicationCall.lateralisIdentitas() = LateralisIdentitas(identitas("identitas"))
fun ApplicationCall.modusOnerisIdentitas() = ModusOnerisIdentitas(identitas("identitas"))