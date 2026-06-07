package moderatores.instrumentorum

import auxilia.instrumentaIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.instrumentorum.ServitiumInstrumenta

fun Route.moderatorInstrumenta() {

    route("/instrumenta") {
        get {
            call.respond(
                ServitiumInstrumenta.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumInstrumenta.invenire(call.instrumentaIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}