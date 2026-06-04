package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.disciplinarum.tabula.Motus

class MinisteriumMotus() {
    fun inserta(motus: Motus): Int =
        ConexioArsDisciplina.inserta(
            """
                INSERT INTO ars_disciplina.disciplinarum.motus(nomen_motus, descriptio)
                VALUES (?, ?);
                SELECT SCOPE_IDENTITY();
        """.trimIndent()
        ) {
            setString(1, motus.nomen.valor)
            setString(2, motus.descriptio.valor)
        }
}