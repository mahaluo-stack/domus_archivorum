package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.disciplinarum.tabula.Angulus

class MinisteriumAngulorum {
    fun inserta(angulus: Angulus): Int =
        ConexioArsDisciplina.inserta(
            """
        INSERT INTO ars_disciplina.disciplinarum.angulus(
            angulus
        )
        VALUES (?);
        SELECT SCOPE_IDENTITY();
        """.trimIndent()
        ) {
            setDouble(1, angulus.angulus.valor)
        }
}