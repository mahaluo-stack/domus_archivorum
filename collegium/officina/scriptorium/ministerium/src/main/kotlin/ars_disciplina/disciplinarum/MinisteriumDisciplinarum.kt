package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.disciplinarum.tabula.Disciplinae

object MinisteriumDisciplinarum {
    fun inserta(disciplinae: Disciplinae): Int =
        ConexioArsDisciplina.inserta(
            """
                INSERT INTO ars_disciplina.disciplinarum.disciplinae(nomen_disciplinae, descriptio)
                VALUES (?, ?);
                ON CONFLICT DO NOTHING;
        """.trimIndent()
        ) {
            setString(1, disciplinae.nomen.valor)
            setString(2, disciplinae.descriptio?.valor)
        }
}