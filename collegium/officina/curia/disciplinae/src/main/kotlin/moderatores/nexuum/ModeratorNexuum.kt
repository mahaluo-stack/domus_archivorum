package moderatores.nexuum

import auxilia.musculiIdentitas
import auxilia.musculiParsIdentitas
import auxilia.musculiRegioIdentitas
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import servitium.nexuum.ServitiumMusculiParsMusculi
import servitium.nexuum.ServitiumNexuumMusculiRegio

fun Route.moderatorNexuum() {

    route("/nexuum/musculi") {

        put("/regio/{musculiIdentitas}/{regioIdentitas}") {
            ServitiumNexuumMusculiRegio.ponere(
                call.musculiIdentitas(),
                call.musculiRegioIdentitas()
            )
            call.respond(HttpStatusCode.OK)
        }

        put("/pars/{parsIdentitas}/{musculiIdentitas}") {
            ServitiumMusculiParsMusculi.ponere(
                call.musculiParsIdentitas(),
                call.musculiIdentitas()
            )
            call.respond(HttpStatusCode.OK)
        }
    }
}