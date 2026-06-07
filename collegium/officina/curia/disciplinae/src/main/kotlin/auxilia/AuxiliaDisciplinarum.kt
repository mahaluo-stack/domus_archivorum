package auxilia

import ars_disciplina.disciplinarum.valores.identitas.*
import io.ktor.server.application.*

fun ApplicationCall.disciplinaeIdentitas() = DisciplinaeIdentitas(identitas("identitas"))
fun ApplicationCall.angulusIdentitas() = AngulusIdentitas(identitas("identitas"))
fun ApplicationCall.motusIdentitas() = MotusIdentitas(identitas("identitas"))
fun ApplicationCall.variationesIdentitas() = VariationesIdentitas(identitas("identitas"))
fun ApplicationCall.archetypusIdentitas() = ArchetypusIdentitas(identitas("identitas"))