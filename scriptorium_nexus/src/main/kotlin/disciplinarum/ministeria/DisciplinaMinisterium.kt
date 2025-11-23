package org.example.disciplinarum.ministeria

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import org.example.commune.exceptio.regulae.ExceptioRegulae
import org.example.disciplinarum.depositum.DepositumDisciplinae
import org.example.disciplinarum.regulae.RegulaTribunal

class DisciplinaMinisterium(
    private val tribunal: RegulaTribunal,
    private val depositum: DepositumDisciplinae
) {

    fun creaEtInserta(entia: EntiaDisciplina, tribunal: RegulaTribunal): Int {

        try {
            tribunal.valida(entia)
        } catch (e: ExceptioRegulae) {
            throw e
        }

        val disciplinaId: Int = DepositumDisciplinae.inserta(entia)

        // 3. INSERT INTO JUNCTION TABLES (composition mapping)
        // DepositumDisciplinaMotus.inserta(disciplinaId, entia.motus)

        // if (entia.angulus != null) {
        //   DepositumDisciplinaAngulorum.inserta(disciplinaId, entia.angulus)
        //}

        // DepositumDisciplinaVariationum.inserta(disciplinaId, entia.variationis)
        // DepositumDisciplinaPrehensionum.inserta(disciplinaId, entia.prehensiones)
        // DepositumDisciplinaGenerum.inserta(disciplinaId, entia.generaDisciplinae)

        // 4. RETURN THE NEW DISCIPLINA ID
        return disciplinaId
    }
}