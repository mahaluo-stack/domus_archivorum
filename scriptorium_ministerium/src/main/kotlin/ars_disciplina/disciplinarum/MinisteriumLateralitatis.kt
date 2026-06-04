package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.classificationum.tabula.Lateralis

class MinisteriumLateralitatis {
    fun inserta(lateralis: Lateralis): Int =
        ConexioArsDisciplina.inserta(
            """
                INSERT INTO ars_disciplina.classificationum.lateralis(nomen_lateralis)
                VALUES (?);
                SELECT SCOPE_IDENTITY();
        """.trimIndent()
        ) {
            setString(1, lateralis.nomen.valor)
        }
}