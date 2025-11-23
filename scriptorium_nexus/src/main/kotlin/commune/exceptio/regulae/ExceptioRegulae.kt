package org.example.commune.exceptio.regulae

open class ExceptioRegulae(nuntius: String, causa: Throwable? = null) : RuntimeException(nuntius, causa)