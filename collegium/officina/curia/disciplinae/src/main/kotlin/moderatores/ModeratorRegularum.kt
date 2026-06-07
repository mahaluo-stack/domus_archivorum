package moderatores

import io.ktor.server.routing.*
import moderatores.regularum.moderatorRegulae

fun Route.moderatorRegularum() {

    route("/regularum") {
        moderatorRegulae()
    }
}