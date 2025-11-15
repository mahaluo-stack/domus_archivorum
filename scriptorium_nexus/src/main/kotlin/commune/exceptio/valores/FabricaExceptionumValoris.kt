package exceptio.valores

object FabricaExceptionumValoris {

    fun descriptioLonga(nomenClassis: String, maximum: Int): ExceptioDescriptioLonga =
        ExceptioDescriptioLonga("$nomenClassis descriptio nimis longa est (max $maximum).")

    fun nomenLongum(nomenClassis: String, maximum: Int): ExceptioNomenLongum =
        ExceptioNomenLongum("$nomenClassis nomen nimis longum est (max $maximum).")

    fun tempusFuturum(): ExceptioTempusFuturum =
        ExceptioTempusFuturum("Tempus creationis in futuro esse non potest.")

    fun valorInvalidus(nomenClassis: String, valor: Any): ExceptioValorisInvalidi =
        ExceptioValorisInvalidi("$nomenClassis valor invalidus est: $valor.")

    fun angulusPercentum(nomenClassis: String, percentum: Double) =
        ExceptioAngulusPercentum("$nomenClassis angulus (percentualis) inter -100% et +100% esse debet, fuit $percentum\".")
}