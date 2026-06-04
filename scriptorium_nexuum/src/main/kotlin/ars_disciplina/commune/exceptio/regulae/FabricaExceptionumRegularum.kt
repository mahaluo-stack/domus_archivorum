package org.example.commune.exceptio.regulae

object FabricaExceptionumRegularum {

    fun violatio(nomenRegulae: String, causa: String): org.example.commune.exceptio.regulae.ExceptioRegulae =
        _root_ide_package_.org.example.commune.exceptio.regulae.ExceptioRegulae("Regula '$nomenRegulae' violata: $causa")

    fun absentia(nomenValoris: String): org.example.commune.exceptio.regulae.ExceptioRegulae =
        _root_ide_package_.org.example.commune.exceptio.regulae.ExceptioRegulae("Valor '$nomenValoris' ad regulam perficiendam deest.")

    fun incongruentia(causa: String): org.example.commune.exceptio.regulae.ExceptioRegulae =
        _root_ide_package_.org.example.commune.exceptio.regulae.ExceptioRegulae("Incongruentia regulorum: $causa")

    fun nonApplicabilis(nomenRegulae: String): org.example.commune.exceptio.regulae.ExceptioRegulae =
        _root_ide_package_.org.example.commune.exceptio.regulae.ExceptioRegulae("Regula '$nomenRegulae' huic disciplinae non applicatur.")
}