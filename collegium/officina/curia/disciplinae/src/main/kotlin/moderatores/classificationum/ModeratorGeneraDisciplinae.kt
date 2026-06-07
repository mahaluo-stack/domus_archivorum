package moderatores.classificationum

import auxilia.generaDisciplinaeIdentitas
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.classificationum.ServitiumGeneraDisciplinae

fun Route.moderatorGeneraDisciplinae() {

    route("/genera-disciplinae") {
        get {
            call.respond(
                ServitiumGeneraDisciplinae.omnia()
            )
        }
    }

    route("/{identitas}") {
        get {
            call.respond(
                ServitiumGeneraDisciplinae.invenire(call.generaDisciplinaeIdentitas())
            )
        }
    }

    put("/{identitas}") { }

    delete("/{identitas}") { }
}
