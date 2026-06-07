package commune.exceptio


open class ExceptioAuxilia(nuntius: String): IllegalArgumentException(nuntius)

class ParametrumDeest(nuntius: String): ExceptioAuxilia(nuntius)

class ParametrumInvalidum(nuntius: String): ExceptioAuxilia(nuntius)