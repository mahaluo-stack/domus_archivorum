package moderatores.musculorum

import auxilia.musculiRegioIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.musculorum.ServitiumMusculiRegio

fun Route.moderatorMusculiRegio() {

    route("/musculi-regio") {
        get {
            call.respond(
                ServitiumMusculiRegio.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumMusculiRegio.invenire(call.musculiRegioIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}