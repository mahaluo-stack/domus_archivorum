package moderatores.disciplinarum

import auxilia.motusIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.disciplinarum.ServitiumMotuum

fun Route.moderatorMotus() {

    route("/motus") {
        get {
            call.respond(
                ServitiumMotuum.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumMotuum
                    .invenire(call.motusIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}