package org.example.commune.exceptio.structoris

open class ExceptioStructoris(nuntius: String, causa: Throwable? = null) : RuntimeException(nuntius, causa)

class ExceptioStructorisDisciplinae(nuntius: String, causa: Throwable? = null) : ExceptioStructoris(nuntius, causa)