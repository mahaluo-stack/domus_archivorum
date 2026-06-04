package org.example.disciplinarum.ministeria

import ars_disciplina.commune.Conexio
import ars_disciplina.disciplinarum.tabula.Motus

class MinisteriumMotus() {
    fun inserta(motus: Motus): Int {
        Conexio.getConnection().use { conn ->
            val sql = """
                INSERT INTO ars_disciplina.disciplinarum.motus(nomen_motus, descriptio)
                VALUES (?, ?);
                SELECT SCOPE_IDENTITY();
            """
            conn.prepareStatement(sql).use { ps ->
                ps.setString(1, motus.nomen.toString())
                ps.setString(2, motus.descriptio.toString())
                ps.executeQuery().use { rs ->
                    rs.next()
                    return rs.getInt(1)
                }
            }
        }
    }
}