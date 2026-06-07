package moderatores.prehensionum

import auxilia.prehensionesIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.prehensionum.ServitiumPrehensionis

fun Route.moderatorPrehensiones() {

    route("/prehensiones") {
        get {
            call.respond(
                ServitiumPrehensionis.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumPrehensionis.invenire(call.prehensionesIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}