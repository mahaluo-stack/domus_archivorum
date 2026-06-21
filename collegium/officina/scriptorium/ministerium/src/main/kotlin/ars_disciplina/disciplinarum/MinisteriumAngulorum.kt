package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.disciplinarum.tabula.Angulus

object MinisteriumAngulorum {
    fun inserta(angulus: Angulus): Int =
        ConexioArsDisciplina.inserta(
            """
        INSERT INTO ars_disciplina.disciplinarum.angulus(
            angulus
        )
        VALUES (?);
        ON CONFLICT DO NOTHING;
        """.trimIndent()
        ) {
            setDouble(1, angulus.angulus.valor)
        }
}