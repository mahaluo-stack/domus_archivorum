package ars_disciplina.disciplinarum.regulae

import org.example.commune.exemplaria.interfacia.ArchetypusDisciplinae
import org.example.commune.regulae.RegulaTribunal
import org.example.disciplinarum.regulae.regulaeArchetyporum

object RegistratorRegularumArchetyporum {
    fun registra(
        tribunal: RegulaTribunal,
        archetypus: ArchetypusDisciplinae
    ) {
        regulaeArchetyporum(tribunal, archetypus.disciplinae) {
            archetypus.regulae.forEach { regula ->
                ApplicatoresRegularum
                    .omnes[regula]
                    ?.invoke(this, archetypus)
            }
        }
    }
}