package org.curia_disciplinae

import ars_disciplina.RenovatorRegistrorum
import configureHTTP
import configureRouting
import configureSerialization
import io.ktor.server.application.*

fun Application.module() {

    RenovatorRegistrorum.initializaRegistrum();

    configureHTTP()
    configureSerialization()
    configureRouting()
}