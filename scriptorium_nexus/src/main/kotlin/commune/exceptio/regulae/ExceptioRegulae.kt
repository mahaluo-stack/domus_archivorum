package org.example.commune.exceptio.regulae

open class ExceptioRegulae(nuntius: String, cause: Throwable? = null) : RuntimeException(nuntius, cause)