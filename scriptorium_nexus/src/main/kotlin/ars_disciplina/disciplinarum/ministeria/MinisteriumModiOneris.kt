package org.example.disciplinarum.ministeria

import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.tabula.ModusOneris
import org.example.commune.conexio.Conexio
import kotlin.use

class MinisteriumModiOneris {
    fun inserta(modusOneris: ModusOneris): Int {
        Conexio.getConnection().use { conn ->
            val sql = """
                INSERT INTO ars_disciplina.classificationum.modus_oneris(nomen_modus_oneris)
                VALUES (?);
                SELECT SCOPE_IDENTITY();
            """
            conn.prepareStatement(sql).use { ps ->
                ps.setString(1, modusOneris.nomen.toString())
                ps.executeQuery().use { rs ->
                    rs.next()
                    return rs.getInt(1)
                }
            }
        }
    }
}