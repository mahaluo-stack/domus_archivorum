package commune.exceptio

object FabricaExceptionumAuxiliorum {

    fun identitasDeest(nomenParametri: String) = ParametrumDeest(
        "Parametrum '$nomenParametri' deest."
    )

    fun identitasInvalidi(valor: String) = ParametrumInvalidum(
        "Valor '$valor' non est identitas valida."
    )
}