package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.exceptio.regulae.FabricaExceptionumRegularum
import org.example.commune.exemplaria.constantia.ConstantiaExceptionum.CAUSA_IGNOTA


class RegulaTribunal {

    private val perDisciplina = mutableMapOf<String, MutableList<(EntiaDisciplina) -> Unit>>()

    fun registra(nomen: NomenDisciplinae, regula: (EntiaDisciplina) -> Unit) {
        perDisciplina.computeIfAbsent(nomen.toString().lowercase()) { mutableListOf() }.add(regula)
    }

    fun valida(entia: EntiaDisciplina) {
        val key = entia.disciplinae.nomen.toString().lowercase()
        val regulae = perDisciplina[key] ?: return

        for (r in regulae) {
            try {
                r(entia)
            } catch (e: Exception) {
                throw FabricaExceptionumRegularum.violatio(
                    nomenRegulae = key,
                    causa = e.message ?: CAUSA_IGNOTA
                )
            }
        }
    }
}