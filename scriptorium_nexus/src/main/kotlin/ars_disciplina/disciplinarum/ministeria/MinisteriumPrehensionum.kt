package org.example.disciplinarum.ministeria

import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.tabula.Prehensiones
import org.example.commune.conexio.Conexio
import kotlin.use

class MinisteriumPrehensionum {
    fun inserta(prehensiones: Prehensiones): Int {
        Conexio.getConnection().use { conn ->
            val sql = """
                INSERT INTO ars_disciplina.prehensionum.prehensiones(nomen_prehensionis, descriptio)
                VALUES (?, ?);
                SELECT SCOPE_IDENTITY();
            """
            conn.prepareStatement(sql).use { ps ->
                ps.setString(1, prehensiones.nomen.toString())
                ps.setString(2, prehensiones.descriptio.toString())
                ps.executeQuery().use { rs ->
                    rs.next()
                    return rs.getInt(1)
                }
            }
        }
    }
}