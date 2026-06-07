package moderatores

import io.ktor.server.routing.*
import moderatores.prehensionum.moderatorGenusPrehensionis
import moderatores.prehensionum.moderatorPrehensiones

fun Route.moderatorPrehensionum() {

    route("/prehensionum") {
        moderatorPrehensiones()
        moderatorGenusPrehensionis()
    }
}