package moderatores.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import auxilia.musculiIdentitas
import auxilia.musculiParsIdentitas
import auxilia.musculiRegioIdentitas
import commune.constantia.ConstantiaResponsumDelere
import commune.constantia.ConstantiaResponsumPonere
import commune.contractus.petitio.nexuum.PetitioConfiguratioMusculi
import commune.contractus.petitio.nexuum.PetitioConfiguratioMusculiRegio
import commune.contractus.responsa.Responsum
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import servitium.nexuum.ServitiumMusculiMusculiPars
import servitium.nexuum.ServitiumMusculiRegioMusculi

fun Route.moderatorNexuum() {

    route("/nexuum") {

        get("/musculi-regio") {
            call.respond(
                HttpStatusCode.OK, Responsum(
                    true, "Muscle Group configuration retrieved.", ServitiumMusculiRegioMusculi.omnia()
                )
            )
        }

        put("/musculi-regio") {

            val petitio = call.receive<PetitioConfiguratioMusculiRegio>()

            val exitus = ServitiumMusculiRegioMusculi.ponereConfigurationem(
                petitio.musculiRegioIdentitas,
                petitio.musculiIdentitates
            )

            call.respond(
                HttpStatusCode.OK,
                when (exitus) {
                    ConstantiaResponsumPonere.CREATED -> Responsum<Unit>(
                        true, "Muscle Group configuration created."
                    )

                    ConstantiaResponsumPonere.UNCHANGED -> Responsum(
                        false, "Muscle Group configuration not changed."
                    )

                    ConstantiaResponsumPonere.UPDATED -> Responsum(
                        false, "Muscle Group configuration updated."
                    )
                }
            )
        }

        delete("/musculi-regio/{musculiRegioIdentitas}") {

            val exitus = ServitiumMusculiRegioMusculi.delere(
                call.musculiRegioIdentitas()
            )
            call.respond(
                HttpStatusCode.OK, when (exitus) {
                    ConstantiaResponsumDelere.SUCCESS -> Responsum<Unit>(
                        true, "Muscle configuration removed."
                    )

                    ConstantiaResponsumDelere.NOT_FOUND -> Responsum(
                        false, "Muscle configuration does not exist."
                    )
                }
            )
        }

        get("/musculi") {
            call.respond(
                HttpStatusCode.OK, Responsum(
                    true, "Muscle Part configuration retrieved.", ServitiumMusculiMusculiPars.omnia()
                )
            )
        }

        put("/musculi") {

            val petitio = call.receive<PetitioConfiguratioMusculi>()

            val exitus = ServitiumMusculiMusculiPars.ponereConfigurationem(
                petitio.musculiIdentitas,
                petitio.musculiParsIdentitates
            )

            call.respond(
                HttpStatusCode.OK,
                when (exitus) {
                    ConstantiaResponsumPonere.CREATED -> Responsum<Unit>(
                        true, "Muscle configuration created."
                    )

                    ConstantiaResponsumPonere.UNCHANGED -> Responsum(
                        false, "Muscle configuration not changed."
                    )

                    ConstantiaResponsumPonere.UPDATED -> Responsum(
                        false, "Muscle configuration updated."
                    )
                }
            )
        }

        delete("/musculi/{musculiIdentitas}") {
            val exitus = ServitiumMusculiMusculiPars.delere(
                call.musculiIdentitas()
            )
            call.respond(
                HttpStatusCode.OK, when (exitus) {
                    ConstantiaResponsumDelere.SUCCESS -> Responsum<Unit>(
                        true, "Muscle configuration removed."
                    )

                    ConstantiaResponsumDelere.NOT_FOUND -> Responsum(
                        false, "Muscle configuration does not exist."
                    )
                }
            )
        }
    }
}