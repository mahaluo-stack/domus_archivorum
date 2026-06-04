package org.example.disciplinarum.ministeria

import ConexioArsDisciplina
import ars_disciplina.prehensionum.tabula.Prehensiones

class MinisteriumPrehensionum {
    fun inserta(prehensiones: Prehensiones): Int =
        ConexioArsDisciplina.inserta(
            """
                INSERT INTO ars_disciplina.prehensionum.prehensiones(nomen_prehensionis, descriptio)
                VALUES (?, ?);
                SELECT SCOPE_IDENTITY();
        """.trimIndent()
        ) {
            setString(1, prehensiones.nomen.valor)
            setString(2, prehensiones.descriptio.valor)
        }
}