package moderatores.musculorum

import auxilia.musculiIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.musculorum.ServitiumMusculi

fun Route.moderatorMusculi() {

    route("/musculi") {
        get {
            call.respond(
                ServitiumMusculi.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumMusculi.invenire(call.musculiIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}