package moderatores

import io.ktor.server.routing.*
import moderatores.classificationum.moderatorGeneraDisciplinae
import moderatores.classificationum.moderatorLateralis
import moderatores.classificationum.moderatorModusOneris

fun Route.moderatorClassificationum() {

    route("/classificationum") {
        moderatorGeneraDisciplinae()
        moderatorLateralis()
        moderatorModusOneris()
    }
}