package org.example.disciplinarum.ministeria

import ars_disciplina.disciplinarum.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.Angulus
import org.example.commune.conexio.Conexio
import kotlin.use

class MinisteriumAngulorum {
    fun inserta(angulus: Angulus): Int {
        Conexio.getConnection().use { conn ->
            val sql = """
                INSERT INTO ars_disciplina.disciplinarum.angulus(angulus)
                VALUES (?);
                SELECT SCOPE_IDENTITY();
            """
            conn.prepareStatement(sql).use { ps ->
                ps.setDouble(1, angulus.angulus.valor)
                ps.executeQuery().use { rs ->
                    rs.next()
                    return rs.getInt(1)
                }
            }
        }
    }
}