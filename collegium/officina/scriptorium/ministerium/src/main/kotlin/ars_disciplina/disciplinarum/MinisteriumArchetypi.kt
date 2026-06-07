package ars_disciplina.disciplinarum

import ConexioArsDisciplina
import ars_disciplina.disciplinarum.tabula.Archetypus

class MinisteriumArchetypi {
    fun inserta(nomenArchetypi: Archetypus): Int =
        ConexioArsDisciplina.inserta(
            """
        INSERT INTO ars_disciplina.disciplinarum.archetypi(
            nomen_archetypi,
            descriptio
        )
        VALUES (?, ?);
        SELECT SCOPE_IDENTITY();
        """.trimIndent()
        ) {
            setString(1, nomenArchetypi.nomenArchetypi.valor)
            setString(1, nomenArchetypi.descriptio.valor)
        }
}