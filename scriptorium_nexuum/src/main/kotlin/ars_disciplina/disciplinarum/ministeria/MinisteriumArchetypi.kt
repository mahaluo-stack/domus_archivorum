package ars_disciplina.disciplinarum.ministeria

import ars_disciplina.disciplinarum.DepositumArchetypi
import org.example.commune.exemplaria.interfacia.ArchetypusDisciplinae

object MinisteriumArchetypi {
    fun insertaSiNonExstat(
        archetypusDisciplinae: ArchetypusDisciplinae
    ) {
        if (
            DepositumArchetypi.exstatArchetypi(archetypusDisciplinae.archetypus.nomenArchetypi.valor)
        ) {
            return
        }
        DepositumArchetypi.insertaArchetypi(archetypusDisciplinae.archetypus)
    }
}