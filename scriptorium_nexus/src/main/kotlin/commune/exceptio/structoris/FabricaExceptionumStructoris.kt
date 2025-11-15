package org.example.commune.exceptio.structoris

object FabricaExceptionumStructoris {

    fun incompleta(nomen: String): ExceptioStructorisDisciplinae =
        ExceptioStructorisDisciplinae("$nomen structor campos necessarios non habet.")

    fun valorInvalidus(nomen: String, causa: String): ExceptioStructorisDisciplinae =
        ExceptioStructorisDisciplinae("$nomen valor invalidus: $causa.")

    fun incongruentia(nomen: String, causa: String): ExceptioStructorisDisciplinae =
        ExceptioStructorisDisciplinae("$nomen structor incongruens: $causa.")
}