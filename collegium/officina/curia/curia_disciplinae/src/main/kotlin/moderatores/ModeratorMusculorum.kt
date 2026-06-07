package moderatores

import io.ktor.server.routing.*
import moderatores.musculorum.moderatorMusculi
import moderatores.musculorum.moderatorMusculiPars
import moderatores.musculorum.moderatorMusculiRegio

fun Route.moderatorMusculorum() {

    route("/musculorum") {
        moderatorMusculi()
        moderatorMusculiPars()
        moderatorMusculiRegio()
    }
}