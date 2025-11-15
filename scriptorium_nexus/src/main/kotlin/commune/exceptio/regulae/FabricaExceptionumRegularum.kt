package org.example.commune.exceptio.regulae

object FabricaExceptionumRegularum {

    fun violatio(nomenRegulae: String, causa: String): ExceptioRegulae =
        ExceptioRegulae("Regula '$nomenRegulae' violata: $causa")

    fun absentia(nomenValoris: String): ExceptioRegulae =
        ExceptioRegulae("Valor '$nomenValoris' ad regulam perficiendam deest.")

    fun incongruentia(causa: String): ExceptioRegulae =
        ExceptioRegulae("Incongruentia regulorum: $causa")

    fun nonApplicabilis(nomenRegulae: String): ExceptioRegulae =
        ExceptioRegulae("Regula '$nomenRegulae' huic disciplinae non applicatur.")
}