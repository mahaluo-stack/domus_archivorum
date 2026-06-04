package org.example.disciplinarum.ministeria

import ars_disciplina.commune.Conexio
import ars_disciplina.disciplinarum.tabula.Variationes

class MinisteriumVariationum {
    fun inserta(variationes: Variationes): Int {
        Conexio.getConnection().use { conn ->
            val sql = """
                INSERT INTO ars_disciplina.disciplinarum.variationes(nomen_variationis)
                VALUES (?);
                SELECT SCOPE_IDENTITY();
            """
            conn.prepareStatement(sql).use { ps ->
                ps.setString(1, variationes.nomen.toString())
                ps.executeQuery().use { rs ->
                    rs.next()
                    return rs.getInt(1)
                }
            }
        }
    }
}