package ars_disciplina.instrumentorum

import ConexioArsDisciplina
import ars_disciplina.instrumentorum.tabula.GenusInstrumenti

object MinisteriumGenerumInstrumenti {
    fun inserta(genusInstrumenti: GenusInstrumenti): Int =
        ConexioArsDisciplina.inserta(
            """
                INSERT INTO ars_disciplina.instrumentorum.genus_instrumenti(nomen_genus_instrumenti)
                VALUES (?);
                SELECT SCOPE_IDENTITY();
        """.trimIndent()
        ) {
            setString(1, genusInstrumenti.nomen.valor)
        }
}