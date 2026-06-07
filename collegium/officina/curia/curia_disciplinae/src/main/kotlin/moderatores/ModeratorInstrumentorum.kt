package moderatores

import io.ktor.server.routing.*
import moderatores.instrumentorum.moderatorGenusInstrumenti
import moderatores.instrumentorum.moderatorInstrumenta

fun Route.moderatorInstrumentorum() {

    route("/instrumentorum") {
        moderatorInstrumenta()
        moderatorGenusInstrumenti()
    }
}