package moderatores.entia

import commune.contractus.responsa.Responsum
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import servitium.entia.ServitiumEntiaMusculi

fun Route.moderatorEntia() {
    route("/entia") {
        get("/musculi") {
            call.respond(
                HttpStatusCode.OK, Responsum(
                    true, "Muscle entities retrieved.", ServitiumEntiaMusculi.omnia()
                )
            )
        }
    }
}