package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.exceptio.regulae.FabricaExceptionumRegularum

object RegulaDeadlift {

    fun registra(tribunal: RegulaTribunal) {

        tribunal.registra(NomenDisciplinae("deadlift")) { d ->
            if (d.angulus != null) {
                throw FabricaExceptionumRegularum.violatio(
                    "deadlift",
                    "angulus non permittitur."
                )
            }
        }

        tribunal.registra(NomenDisciplinae("deadlift")) { d ->
            val motusNomen = d.motus.singleOrNull()?.nomen?.toString()?.lowercase()
            if (motusNomen != "pull") {
                throw FabricaExceptionumRegularum.violatio("deadlift", "Deadlift motus debet esse 'pull' unicus."
                )
            }
        }
    }
}