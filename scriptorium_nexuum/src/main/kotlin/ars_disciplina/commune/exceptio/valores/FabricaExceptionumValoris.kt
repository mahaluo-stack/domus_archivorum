package exceptio.valores

object FabricaExceptionumValoris {

    fun descriptioLonga(nomenClassis: String, maximum: Int): exceptio.valores.ExceptioDescriptioLonga =
        _root_ide_package_.exceptio.valores.ExceptioDescriptioLonga("$nomenClassis descriptio nimis longa est (max $maximum).")

    fun nomenLongum(nomenClassis: String, maximum: Int): exceptio.valores.ExceptioNomenLongum =
        _root_ide_package_.exceptio.valores.ExceptioNomenLongum("$nomenClassis nomen nimis longum est (max $maximum).")

    fun tempusFuturum(): exceptio.valores.ExceptioTempusFuturum =
        _root_ide_package_.exceptio.valores.ExceptioTempusFuturum("Tempus creationis in futuro esse non potest.")

    fun valorInvalidus(nomenClassis: String, valor: Any): exceptio.valores.ExceptioValorisInvalidi =
        _root_ide_package_.exceptio.valores.ExceptioValorisInvalidi("$nomenClassis valor invalidus est: $valor.")

    fun angulusPercentum(nomenClassis: String, percentum: Double) =
        _root_ide_package_.exceptio.valores.ExceptioAngulusPercentum("$nomenClassis angulus (percentualis) inter -100% et +100% esse debet, fuit $percentum\".")
}