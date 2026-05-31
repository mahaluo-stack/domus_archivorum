package org.example.disciplinarum.ministeria

import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import org.example.commune.conexio.Conexio
import kotlin.use

class MinisteriumLateralitatis {
    fun inserta(lateralis: Lateralis): Int {
        Conexio.getConnection().use { conn ->
            val sql = """
                INSERT INTO ars_disciplina.classificationum.lateralis(nomen_lateralis)
                VALUES (?);
                SELECT SCOPE_IDENTITY();
            """
            conn.prepareStatement(sql).use { ps ->
                ps.setString(1, lateralis.nomen.toString())
                ps.executeQuery().use { rs ->
                    rs.next()
                    return rs.getInt(1)
                }
            }
        }
    }
}