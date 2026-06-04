package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.disciplinarum.tabula.Disciplinae

class MinisteriumDisciplinarum() {
    fun inserta(disciplinae: Disciplinae): Int =
        ConexioArsDisciplina.inserta(
            """
                INSERT INTO ars_disciplina.disciplinarum.disciplinae(nomen_disciplinae, descriptio)
                VALUES (?, ?);
                SELECT SCOPE_IDENTITY();
        """.trimIndent()
        ) {
            setString(1, disciplinae.nomen.valor)
            setString(2, disciplinae.descriptio?.valor)
        }
}