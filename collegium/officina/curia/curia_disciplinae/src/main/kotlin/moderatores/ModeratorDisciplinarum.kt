package moderatores

import io.ktor.server.routing.*
import moderatores.disciplinarum.*

fun Route.moderatorDisciplinarum() {

    route("/disciplinarum") {

        get("/entia/{identitas}") { }

        moderatorDisciplinae()
        moderatorMotus()
        moderatorVariationes()
        moderatorAngulus()
        moderatorArchetypi()
    }
}