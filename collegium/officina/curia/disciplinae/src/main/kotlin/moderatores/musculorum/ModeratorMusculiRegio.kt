package moderatores.musculorum

import auxilia.cascade
import auxilia.musculiRegioIdentitas
import commune.constantia.ConstantiaResponsumCreata
import commune.constantia.ConstantiaResponsumDelereRegistra
import commune.constantia.ConstantiaResponsumPonere
import commune.contractus.petitio.musculorum.PetitioMusculiRegio
import commune.contractus.responsa.Responsum
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.musculorum.ServitiumMusculiRegio

fun Route.moderatorMusculiRegio() {

    route("/musculi-regio") {
        get {
            call.respond(
                HttpStatusCode.OK, Responsum(
                    true, "Muscle Groups retrieved.", ServitiumMusculiRegio.omnia()
                )
            )
        }
    }

    post {
        val petitio = call.receive<PetitioMusculiRegio>()
        val exitus = ServitiumMusculiRegio.creata(petitio)

        call.respond(
            HttpStatusCode.OK, when (exitus) {
                ConstantiaResponsumCreata.SUCCESS -> Responsum<Unit>(
                    true, "Muscle Group created."
                )

                ConstantiaResponsumCreata.EXISTING -> Responsum(
                    false, "Muscle Group already exists."
                )
            }
        )
    }

    route("/{identitas}") {
        get {
            val musculiRegio = ServitiumMusculiRegio.invenireSiAdest(call.musculiRegioIdentitas())
            if (musculiRegio == null) {
                call.respond(
                    HttpStatusCode.NotFound, Responsum<Unit>(
                        false, "Muscle Group not found."
                    )
                )
            } else {
                call.respond(
                    HttpStatusCode.OK, Responsum(
                        true, "Muscle Group retrieved.", musculiRegio
                    )
                )
            }
        }

        put {
            val petitio = call.receive<PetitioMusculiRegio>()
            val exitus = ServitiumMusculiRegio.ponere(petitio)

            call.respond(
                HttpStatusCode.OK, when (exitus) {
                    ConstantiaResponsumPonere.CREATED -> Responsum<Unit>(
                        true, "Muscle Group created."
                    )

                    ConstantiaResponsumPonere.UNCHANGED -> Responsum(
                        false, "Muscle Group not changed."
                    )

                    ConstantiaResponsumPonere.UPDATED -> Responsum(
                        true, "Muscle Group updated."
                    )
                }
            )
        }

        delete {
            val exitus = ServitiumMusculiRegio.delere(call.musculiRegioIdentitas(), call.cascade())

            call.respond(
                HttpStatusCode.OK, when (exitus) {
                    ConstantiaResponsumDelereRegistra.SUCCESS -> Responsum<Unit>(
                        true, "Muscle Group removed."
                    )

                    ConstantiaResponsumDelereRegistra.NOT_FOUND -> Responsum(
                        false, "Muscle Group does not exist."
                    )

                    ConstantiaResponsumDelereRegistra.REFERENCED -> Responsum(
                        false, "Muscle Group is referenced."
                    )
                }
            )
        }
    }
}