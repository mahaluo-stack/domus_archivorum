package org.example.commune.exceptio.structoris

object FabricaExceptionumStructoris {

    fun incompleta(nomen: String): org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae =
        _root_ide_package_.org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae("$nomen structor campos necessarios non habet.")

    fun valorInvalidus(nomen: String, causa: String): org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae =
        _root_ide_package_.org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae("$nomen valor invalidus: $causa.")

    fun incongruentia(nomen: String, causa: String): org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae =
        _root_ide_package_.org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae("$nomen structor incongruens: $causa.")
}