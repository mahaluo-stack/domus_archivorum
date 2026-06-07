package moderatores.regularum

import auxilia.regulaeIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.regularum.ServitiumRegulae

fun Route.moderatorRegulae() {

    route("/regulae") {
        get {
            call.respond(
                ServitiumRegulae.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumRegulae.invenire(call.regulaeIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}