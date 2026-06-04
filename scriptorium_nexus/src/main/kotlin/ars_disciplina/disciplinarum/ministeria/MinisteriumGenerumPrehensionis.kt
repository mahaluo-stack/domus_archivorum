package org.example.disciplinarum.ministeria

import ars_disciplina.commune.Conexio
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis

class MinisteriumGenerumPrehensionis {
    fun inserta(generaPrehensionis: GeneraPrehensionis): Int {
        Conexio.getConnection().use { conn ->
            val sql = """
                INSERT INTO ars_disciplina.prehensionum.genera_prehensionis(nomen_genus_prehensionis, descriptio)
                VALUES (?, ?);
                SELECT SCOPE_IDENTITY();
            """
            conn.prepareStatement(sql).use { ps ->
                ps.setString(1, generaPrehensionis.nomen.toString())
                ps.setString(2, generaPrehensionis.descriptio.toString())
                ps.executeQuery().use { rs ->
                    rs.next()
                    return rs.getInt(1)
                }
            }
        }
    }
}