package org.example.commune.exceptio.registra


open class ExceptioRegistra(nuntius: String, causa: Throwable? = null) : IllegalArgumentException(nuntius, causa)