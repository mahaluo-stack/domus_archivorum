package org.example.commune.exceptio.structoris

open class ExceptioStructoris(nuntius: String, cause: Throwable? = null) : RuntimeException(nuntius, cause)

class ExceptioStructorisDisciplinae(nuntius: String, cause: Throwable? = null) : ExceptioStructoris(nuntius, cause)