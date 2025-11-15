package org.example.disciplinarum.depositum

import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.valores.AngulusPercentum
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import org.example.commune.conexio.Conexio

object DepositumAngulus {
    fun legeOmnes(): List<Angulus> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    angulus_identitas, 
                    angulus 
                FROM ars_disciplina.disciplinarum.angulus
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val out = mutableListOf<Angulus>()
                    while (rs.next()) {
                        val identitas = AngulusIdentitas(identitas = rs.getInt("angulus_identitas"))
                        val percentum = AngulusPercentum(percentum = rs.getDouble("angulus"))
                        out.add(
                            Angulus(
                                identitas,
                                percentum
                            )
                        )
                    }
                    return out
                }
            }
        }
    }
}