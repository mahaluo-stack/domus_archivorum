package ars_disciplina

import ConexioArsDisciplina
import java.sql.ResultSet

abstract class Ministerium<T> {

    protected abstract val nomenSchemata: String
    protected abstract val nomenTabulae: String
    protected abstract fun crea(rs: ResultSet): T

    fun inserta(): Int = ConexioArsDisciplina.inserta(
        """
            SELECT *
            FROM $nomenSchemata.$nomenTabulae
        """.trimIndent()
    )
}