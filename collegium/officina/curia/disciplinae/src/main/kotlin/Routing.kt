import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import moderatores.moderatorClassificationum
import moderatores.moderatorDisciplinarum
import moderatores.moderatorInstrumentorum
import moderatores.moderatorMusculorum
import moderatores.moderatorPrehensionum
import moderatores.moderatorRegularum

fun Application.configureRouting() {

    routing { moderatorDisciplinarum() }
    routing { moderatorMusculorum() }
    routing { moderatorClassificationum() }
    routing { moderatorInstrumentorum() }
    routing { moderatorPrehensionum() }
    routing { moderatorRegularum() }
}