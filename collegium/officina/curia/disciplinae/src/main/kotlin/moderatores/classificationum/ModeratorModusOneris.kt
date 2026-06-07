package moderatores.classificationum

import auxilia.modusOnerisIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.classificationum.ServitiumModusOneris

fun Route.moderatorModusOneris() {

    route("/modus-oneris") {
        get {
            call.respond(
                ServitiumModusOneris.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumModusOneris.invenire(call.modusOnerisIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}