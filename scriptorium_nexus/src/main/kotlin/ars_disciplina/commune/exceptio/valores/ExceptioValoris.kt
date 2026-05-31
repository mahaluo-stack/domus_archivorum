package exceptio.valores

open class ExceptioValorisInvalidi(nuntius: String) : IllegalArgumentException(nuntius)

class ExceptioAngulusPercentum(nuntius: String) : exceptio.valores.ExceptioValorisInvalidi(nuntius)

class ExceptioDescriptioLonga(nuntius: String) : exceptio.valores.ExceptioValorisInvalidi(nuntius)

class ExceptioNomenLongum(nuntius: String) : exceptio.valores.ExceptioValorisInvalidi(nuntius)

class ExceptioTempusFuturum(nuntius: String) : exceptio.valores.ExceptioValorisInvalidi(nuntius)