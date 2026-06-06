package moderatores.disciplinarum

import auxilia.disciplinaeIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.disciplinarum.ServitiumDisciplinae

fun Route.disciplinaeModerator() {

    route("/disciplina") {
        get {
            call.respond(
                ServitiumDisciplinae.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumDisciplinae.invenire(call.disciplinaeIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}