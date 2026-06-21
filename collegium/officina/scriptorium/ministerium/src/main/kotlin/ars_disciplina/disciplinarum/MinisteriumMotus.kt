package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.disciplinarum.tabula.Motus

object MinisteriumMotus {
    fun inserta(motus: Motus): Int =
        ConexioArsDisciplina.inserta(
            """
                INSERT INTO ars_disciplina.disciplinarum.motus(nomen_motus, descriptio)
                VALUES (?, ?);
                ON CONFLICT DO NOTHING;
        """.trimIndent()
        ) {
            setString(1, motus.nomen.valor)
            setString(2, motus.descriptio.valor)
        }
}