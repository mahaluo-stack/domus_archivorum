package org.example.nexuum.ministeria.nexus

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import org.example.commune.conexio.Conexio

abstract class MinisteriumNexus<T> {

    protected abstract val nomenTabulae: String
    protected abstract val nomenColumnae: String
    protected abstract fun identitas(identitas: T): Int

    fun inserta(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        identitas: T
    ) {
        insertaOmnes(disciplinaeIdentitas, setOf(identitas))
    }

    fun insertaOmnes(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        identitates: Set<T>
    ) {
        if (identitates.isEmpty()) return

        Conexio.getConnection().use { conn ->
            val sql = """
                INSERT INTO ars_disciplina.nexuum.$nomenTabulae(
                    disciplinae_identitas,
                    $nomenColumnae
                )
                VALUES (?, ?)
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                identitates.forEach {
                    ps.setInt(1, disciplinaeIdentitas.valor)
                    ps.setInt(2, identitas(it))
                    ps.addBatch()
                }
                ps.executeBatch()
            }
        }
    }
}