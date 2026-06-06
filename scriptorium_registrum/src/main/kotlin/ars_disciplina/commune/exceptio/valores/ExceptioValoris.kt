package exceptio.valores

open class ExceptioValorisInvalidi(nuntius: String) : IllegalArgumentException(nuntius)

class ExceptioAngulusPercentum(nuntius: String) : ExceptioValorisInvalidi(nuntius)

class ExceptioDescriptioLonga(nuntius: String) : ExceptioValorisInvalidi(nuntius)

class ExceptioNomenLongum(nuntius: String) : ExceptioValorisInvalidi(nuntius)

class ExceptioTempusFuturum(nuntius: String) : ExceptioValorisInvalidi(nuntius)