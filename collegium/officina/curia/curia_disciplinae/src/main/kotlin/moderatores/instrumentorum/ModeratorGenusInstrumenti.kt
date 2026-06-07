package moderatores.instrumentorum

import auxilia.genusInstrumentiIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.instrumentorum.ServitiumGenusInstrumenti

fun Route.moderatorGenusInstrumenti() {

    route("/genus-instrumenti") {
        get {
            call.respond(
                ServitiumGenusInstrumenti.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumGenusInstrumenti.invenire(call.genusInstrumentiIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}