package org.example.disciplinarum.ministeria

import ars_disciplina.disciplinarum.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.Disciplinae
import org.example.commune.conexio.Conexio

class MinisteriumDisciplinae() {
    fun inserta(disciplinae: Disciplinae): Int {
        Conexio.getConnection().use { conn ->
            val sql = """
                INSERT INTO ars_disciplina.disciplinarum.disciplinae(nomen_disciplinae, descriptio)
                VALUES (?, ?);
                SELECT SCOPE_IDENTITY();
            """
            conn.prepareStatement(sql).use { ps ->
                ps.setString(1, disciplinae.nomen.toString())
                ps.setString(2, disciplinae.descriptio.toString())
                ps.executeQuery().use { rs ->
                    rs.next()
                    return rs.getInt(1)
                }
            }
        }
    }
}