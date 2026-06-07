package moderatores.classificationum

import auxilia.lateralisIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.classificationum.ServitiumLateralis

fun Route.moderatorLateralis() {

    route("/lateralis") {
        get {
            call.respond(
                ServitiumLateralis.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumLateralis.invenire(call.lateralisIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}