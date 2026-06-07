package auxilia

import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas
import io.ktor.server.application.*

fun ApplicationCall.prehensionesIdentitas() = PrehensionesIdentitas(identitas("identitas"))
fun ApplicationCall.generaPrehensionesIdentitas() = GeneraPrehensionisIdentitas(identitas("identitas"))