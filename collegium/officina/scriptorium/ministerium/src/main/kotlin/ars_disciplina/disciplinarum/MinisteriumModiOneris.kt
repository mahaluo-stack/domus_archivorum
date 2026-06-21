package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.classificationum.tabula.ModusOneris

object MinisteriumModiOneris {
    fun inserta(modusOneris: ModusOneris): Int =
        ConexioArsDisciplina.inserta(
            """
                INSERT INTO ars_disciplina.classificationum.modus_oneris(nomen_modus_oneris)
                VALUES (?);
                ON CONFLICT DO NOTHING;
        """.trimIndent()
        ) {
            setString(1, modusOneris.nomen.valor)
        }
}