package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.disciplinarum.tabula.Variationes

class MinisteriumVariationum {
    fun inserta(variationes: Variationes): Int =
        ConexioArsDisciplina.inserta(
            """
                INSERT INTO ars_disciplina.disciplinarum.variationes(nomen_variationis)
                VALUES (?);
                SELECT SCOPE_IDENTITY();
        """.trimIndent()
        ) {
            setString(1, variationes.nomen.valor)
        }
}