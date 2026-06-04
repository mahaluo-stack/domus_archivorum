package ars_disciplina

import ConexioArsDisciplina
import java.sql.ResultSet

abstract class DepositumTabulae<T> {

    protected abstract val nomenSchemata: String
    protected abstract val nomenTabulae: String
    protected abstract fun crea(rs: ResultSet): T

    fun legeOmnes(): Set<T> = ConexioArsDisciplina.legeOmnes(
        """
            SELECT *
            FROM $nomenSchemata.$nomenTabulae
        """.trimIndent(),
        structor = ::crea
    )

    open fun scriptumLectionis(): String =
        """
        SELECT *
        FROM $nomenSchemata.$nomenTabulae
        """.trimIndent()
}