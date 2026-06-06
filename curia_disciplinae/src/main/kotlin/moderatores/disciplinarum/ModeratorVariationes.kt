package moderatores.disciplinarum

import auxilia.variationesIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.disciplinarum.ServitiumVariationes

fun Route.moderatorVariationes() {

    route("/variationes") {
        get {
            call.respond(
                ServitiumVariationes.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumVariationes.invenire(call.variationesIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}