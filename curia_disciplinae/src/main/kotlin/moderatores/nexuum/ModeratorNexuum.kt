package moderatores.nexuum

import io.ktor.server.routing.*

fun Route.moderatorNexuum() {

    route("/nexuum") {

        route("/{identitas}/disciplina-anguli") { get { } }
    }
}