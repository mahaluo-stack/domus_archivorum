package moderatores.prehensionum

import auxilia.generaPrehensionesIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.prehensionum.ServitiumGeneraPrehensionis

fun Route.moderatorGenusPrehensionis() {

    route("/genus-prehensionis") {
        get {
            call.respond(
                ServitiumGeneraPrehensionis.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumGeneraPrehensionis.invenire(call.generaPrehensionesIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}