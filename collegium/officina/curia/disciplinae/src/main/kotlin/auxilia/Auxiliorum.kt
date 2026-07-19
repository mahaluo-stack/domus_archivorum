package auxilia

import commune.exceptio.FabricaExceptionumAuxiliorum
import io.ktor.server.application.*

fun ApplicationCall.identitas(nomen: String): Int {

    val valor = parameters[nomen]
        ?: throw FabricaExceptionumAuxiliorum.identitasDeest(nomen)

    return valor.toIntOrNull()
        ?: throw FabricaExceptionumAuxiliorum.identitasInvalidi(valor)
}

fun ApplicationCall.cascade(): Boolean =
    request.queryParameters["cascade"]?.toBooleanStrictOrNull() ?: false