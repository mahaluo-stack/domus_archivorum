package moderatores

import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import moderatores.disciplinarum.disciplinaeModerator

fun Route.moderatorDisciplinarum() {

    route("/disciplinarum") {

        disciplinaeModerator()

        motusRoutes()

        variationesRoutes()

        anguliRoutes()

        archetypiRoutes()
    }

    get("/disciplinarum/entia/{identitas}") { }
}