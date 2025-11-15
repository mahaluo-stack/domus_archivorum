package org.example.exemplaria.interfacies

import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.CLASSIS_IGNOTA

interface InterfaciaValida {
    val nomenClassis: String
        get() = this::class.simpleName ?: CLASSIS_IGNOTA
}