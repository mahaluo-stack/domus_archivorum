package org.example.nexuum.ministeria.entia

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import org.example.commune.exceptio.regulae.ExceptioRegulae
import org.example.commune.regulae.RegulaTribunal
import org.example.nexuum.ministeria.nexus.MinisteriumDisciplinaAnguli

class MinisteriumEntitatisDisciplinae(
    private val tribunal: RegulaTribunal,
    private val ministeriumDisciplinaAnguli: MinisteriumDisciplinaAnguli
) {
    fun perscribe(entia: EntiaDisciplina): Int {

        try {
            tribunal.valida(entia.disciplinae.nomen.toString(), entia)
        } catch (e: ExceptioRegulae) {
            throw e
        }

        ministeriumDisciplinaAnguli.insertaOmnes(entia.disciplinae, entia.angulus)

        return 0
    }
}