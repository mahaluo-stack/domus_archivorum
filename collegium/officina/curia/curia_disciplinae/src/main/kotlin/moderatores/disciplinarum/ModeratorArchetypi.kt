package moderatores.disciplinarum

import auxilia.archetypusIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.disciplinarum.ServitiumArchetypi

fun Route.moderatorArchetypi() {

    route("/archetypi") {
        get {
            call.respond(
                ServitiumArchetypi.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumArchetypi.invenire(call.archetypusIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}