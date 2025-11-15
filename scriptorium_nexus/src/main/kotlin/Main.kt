package org.example

import org.example.commune.registrum.RegistraMotus
import org.example.init.InitNexus


fun main() {

    InitNexus.initializa()

    val test = RegistraMotus.items()

    test.forEach { println(it) }
}