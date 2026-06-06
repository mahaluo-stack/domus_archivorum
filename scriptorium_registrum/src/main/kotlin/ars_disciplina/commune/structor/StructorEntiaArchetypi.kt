package ars_disciplina.commune.structor

import ars_disciplina.disciplinarum.entia.EntiaArchetypi
import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.Archetypus
import org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae

class StructorEntiaArchetypi {
    private lateinit var archetypus: Archetypus
    private lateinit var entiaDisciplina: Set<EntiaDisciplina>

    fun struct(): EntiaArchetypi {
        if (!::archetypus.isInitialized)
            throw ExceptioStructorisDisciplinae("Archetypus necessaria est.")

        if (!::entiaDisciplina.isInitialized || entiaDisciplina.isEmpty())
            throw ExceptioStructorisDisciplinae("Entia disciplinae necessarius est.")

        return EntiaArchetypi(archetypus, entiaDisciplina
        )
    }
}