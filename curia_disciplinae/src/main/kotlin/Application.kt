package org.curia_disciplinae

import ars_disciplina.Registra
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import moderatores.moderatorDisciplinarum

fun Application.module() {

    Registra.initializa()

    install(ContentNegotiation) { json() }

    routing { moderatorDisciplinarum() }
}