package moderatores.musculorum

import auxilia.musculiParsIdentitas
import commune.constantia.ConstantiaResponsumCreata
import commune.constantia.ConstantiaResponsumDelereRegistra
import commune.constantia.ConstantiaResponsumPonere
import commune.contractus.petitio.musculorum.PetitioMusculiPars
import commune.contractus.responsa.Responsum
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.musculorum.ServitiumMusculiPars

fun Route.moderatorMusculiPars() {

    route("/musculi-pars") {
        get {
            call.respond(
                HttpStatusCode.OK, Responsum(
                    true, "Muscle Parts retrieved.", ServitiumMusculiPars.omnia()
                )
            )
        }
    }

    post {
        val petitio = call.receive<PetitioMusculiPars>()
        val exitus = ServitiumMusculiPars.creata(petitio)

        call.respond(
            HttpStatusCode.OK, when (exitus) {
                ConstantiaResponsumCreata.SUCCESS -> Responsum<Unit>(
                    true, "Muscle Part created."
                )

                ConstantiaResponsumCreata.EXISTING -> Responsum(
                    false, "Muscle Part already exists."
                )
            }
        )
    }

    route("/{identitas}") {
        get {
            val musculiPars = ServitiumMusculiPars.invenireSiAdest(call.musculiParsIdentitas())
            if (musculiPars == null) {
                call.respond(
                    HttpStatusCode.NotFound, Responsum<Unit>(
                        false, "Muscle Part not found."
                    )
                )
            } else {
                call.respond(
                    HttpStatusCode.OK, Responsum(
                        true, "Muscle Part retrieved.", musculiPars
                    )
                )
            }
        }

        put {
            val petitio = call.receive<PetitioMusculiPars>()
            val exitus = ServitiumMusculiPars.ponere(petitio)

            call.respond(
                HttpStatusCode.OK, when (exitus) {
                    ConstantiaResponsumPonere.CREATED -> Responsum<Unit>(
                        true, "Muscle Part created."
                    )

                    ConstantiaResponsumPonere.UNCHANGED -> Responsum(
                        false, "Muscle Part not changed."
                    )

                    ConstantiaResponsumPonere.UPDATED -> Responsum(
                        true, "Muscle Part updated."
                    )
                }
            )
        }

        delete {
            val exitus = ServitiumMusculiPars.delere(call.musculiParsIdentitas())

            call.respond(
                HttpStatusCode.OK, when (exitus) {
                    ConstantiaResponsumDelereRegistra.SUCCESS -> Responsum<Unit>(
                        true, "Muscle Part removed."
                    )

                    ConstantiaResponsumDelereRegistra.NOT_FOUND -> Responsum(
                        false, "Muscle Part does not exist."
                    )

                    ConstantiaResponsumDelereRegistra.REFERENCED -> Responsum(
                        false, "Muscle Part is referenced."
                    )
                }
            )
        }
    }
}