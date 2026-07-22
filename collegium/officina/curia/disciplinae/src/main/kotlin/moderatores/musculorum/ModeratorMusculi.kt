package moderatores.musculorum

import auxilia.cascade
import auxilia.musculiIdentitas
import commune.constantia.ConstantiaResponsumCreata
import commune.constantia.ConstantiaResponsumDelereRegistra
import commune.constantia.ConstantiaResponsumPonere
import commune.contractus.petitio.musculorum.PetitioMusculi
import commune.contractus.responsa.Responsum
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import servitium.musculorum.ServitiumMusculi

fun Route.moderatorMusculi() {

    route("/musculi") {
        get {
            call.respond(
                HttpStatusCode.OK,
                Responsum(
                    true,
                    "Muscles retrieved.",
                    ServitiumMusculi.omnia()
                )
            )
        }

        post {
            val petitio = call.receive<PetitioMusculi>()
            val exitus = ServitiumMusculi.creata(petitio)

            call.respond(
                HttpStatusCode.OK,
                when (exitus) {
                    ConstantiaResponsumCreata.SUCCESS -> Responsum<Unit>(
                        true, "Muscle created."
                    )

                    ConstantiaResponsumCreata.EXISTING -> Responsum(
                        false, "Muscle already exists."
                    )
                }
            )
        }

        route("/{identitas}") {
            get {
                val musculi = ServitiumMusculi.invenireSiAdest(call.musculiIdentitas())
                if (musculi == null) {
                    call.respond(
                        HttpStatusCode.NotFound,
                        Responsum<Unit>(
                            false,
                            "Muscle not found."
                        )
                    )
                } else {
                    call.respond(
                        HttpStatusCode.OK,
                        Responsum(
                            true,
                            "Muscle retrieved.",
                            musculi
                        )
                    )
                }
            }

            put {
                val petitio = call.receive<PetitioMusculi>()
                val exitus = ServitiumMusculi.ponere(petitio)

                call.respond(
                    HttpStatusCode.OK,
                    when (exitus) {
                        ConstantiaResponsumPonere.CREATED -> Responsum<Unit>(
                            true, "Muscle created."
                        )

                        ConstantiaResponsumPonere.UNCHANGED -> Responsum(
                            false, "Muscle not changed."
                        )

                        ConstantiaResponsumPonere.UPDATED -> Responsum(
                            true, "Muscle updated."
                        )
                    }
                )
            }

            delete {
                val exitus = ServitiumMusculi.delere(call.musculiIdentitas(), call.cascade())

                call.respond(
                    HttpStatusCode.OK, when (exitus) {
                        ConstantiaResponsumDelereRegistra.SUCCESS -> Responsum<Unit>(
                            true, "Muscle removed."
                        )
                        ConstantiaResponsumDelereRegistra.NOT_FOUND -> Responsum(
                            false, "Muscle does not exist."
                        )
                        ConstantiaResponsumDelereRegistra.REFERENCED -> Responsum(
                            false, "Muscle is referenced."
                        )
                    }
                )
            }
        }
    }
}