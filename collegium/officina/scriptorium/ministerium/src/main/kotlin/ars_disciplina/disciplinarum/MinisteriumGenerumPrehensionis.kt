package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis

object MinisteriumGenerumPrehensionis {
    fun inserta(generaPrehensionis: GeneraPrehensionis): Int =
        ConexioArsDisciplina.inserta(
            """
                INSERT INTO ars_disciplina.prehensionum.genera_prehensionis(nomen_genus_prehensionis, descriptio)
                VALUES (?, ?);
                ON CONFLICT DO NOTHING;
        """.trimIndent()
        ) {
            setString(1, generaPrehensionis.nomen.valor)
            setString(2, generaPrehensionis.descriptio?.valor)
        }
}