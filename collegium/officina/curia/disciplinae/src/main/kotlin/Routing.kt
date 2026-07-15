import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import moderatores.entia.moderatorEntia
import moderatores.moderatorClassificationum
import moderatores.moderatorDisciplinarum
import moderatores.moderatorInstrumentorum
import moderatores.moderatorMusculorum
import moderatores.moderatorPrehensionum
import moderatores.moderatorRegularum
import moderatores.nexuum.moderatorNexuum

fun Application.configureRouting() {

    routing { moderatorDisciplinarum() }
    routing { moderatorMusculorum() }
    routing { moderatorClassificationum() }
    routing { moderatorInstrumentorum() }
    routing { moderatorPrehensionum() }
    routing { moderatorRegularum() }
    routing { moderatorNexuum() }
    routing { moderatorEntia() }
}