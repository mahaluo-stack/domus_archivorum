package moderatores.disciplinarum

import auxilia.angulusIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.disciplinarum.ServitiumAnguli

fun Route.moderatorAngulus() {

    route("/angulus") {
        get {
            call.respond(
                ServitiumAnguli.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumAnguli.invenire(call.angulusIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}
