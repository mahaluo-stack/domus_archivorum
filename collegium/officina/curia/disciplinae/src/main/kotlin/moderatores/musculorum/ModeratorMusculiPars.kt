package moderatores.musculorum

import auxilia.musculiParsIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.musculorum.ServitiumMusculiPars

fun Route.moderatorMusculiPars() {

    route("/musculi-pars") {
        get {
            call.respond(
                ServitiumMusculiPars.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumMusculiPars.invenire(call.musculiParsIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}